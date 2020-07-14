package net.skhu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.LoginUser;
import net.skhu.domain.User;
import net.skhu.repository.UserRepository;
import net.skhu.service.UserService;

@RequestMapping("user")
@RestController
public class UserController {

	@Autowired UserService userService;
	@Autowired UserRepository userRepository;

    // 회원가입
	@PostMapping("signup")
    public User signup(@RequestBody User user) {
    	//User user=new User("admin1","1234","한지민","관리자1","admin1@naver.com","010-1234-5678","관리자");
        userService.joinUser(user);
        return user;
    }

    // 로그인
	@PostMapping("login")
    public int login(@RequestBody LoginUser loginUser) {
    	//User user=new User("admin1","1234","한지민","관리자1","admin1@naver.com","010-1234-5678","관리자");
		Optional<User> user=userService.login(loginUser.getLoginId(), loginUser.getPassword());
        if(user==null)
        	return 0; //로그인 실패
        else
        	return 1; //로그인 성공
    }

    //리스트 출력
    @RequestMapping("find")
    public List<User> find() {
        return userRepository.findAll();
    }

    //user 하나 출력
    @RequestMapping("findBy")
    public Optional<User> findBy() {
        return userRepository.findById("admin1");
    }


}