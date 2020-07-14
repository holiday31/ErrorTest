package net.skhu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.domain.User;
import net.skhu.repository.UserRepository;
import net.skhu.utils.EncryptionUtils;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    @Transactional
    public String joinUser(User user) {
        // 비밀번호 암호화
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
    	user.setPassword(EncryptionUtils.encryptMD5(user.getPassword()));
        return userRepository.save(user).getId();
    }

    public Optional<User> login(String loginId, String password) {
        Optional<User> user = userRepository.findById(loginId);
        if (user == null) return null;
        String pw = EncryptionUtils.encryptMD5(password);
        if (user.get().getPassword().equals(pw) == false) return null;
        return user;
    }



}