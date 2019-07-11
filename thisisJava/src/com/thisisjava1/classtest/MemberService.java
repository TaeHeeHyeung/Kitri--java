package com.thisisjava1.classtest;

public class MemberService {
	String id;
	String password;
	public boolean login(String id, String password) {
		return (this.id.equals(id) &&this.password.equals(password));
	}
	public void logout(String id) {
		if(this.id.equals(id))
			System.out.println("로그아웃 되었습니다.");
	}  
}
