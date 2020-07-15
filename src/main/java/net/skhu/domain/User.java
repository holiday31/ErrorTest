package net.skhu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

import lombok.Data;

@Data
@Entity
@Table(appliesTo = "user")
public class User {
	@Id
	String id;
	String password;

	String name;
	String nickname;
	String email;
	String phone;
	String userType;

//	String name="한지민";
//	String nickname="관리자1";
//	String email="abc@naver.com";
//	String phone="010-1234-5678";
//	String userType="관리자";

	public User() {

	}

	public User(String id, String password, String name, String nickname, String email, String phone, String userType) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.userType = userType;
	}

}

