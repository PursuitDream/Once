package com.rent.action;


import com.rent.service.LoginService;
import com.rent.vo.AdminVO;

public class LoginAction{
	
	private String user;
	private String pass;
	
	public String login() {

		try {
			LoginService ls  =new LoginService();
			AdminVO admin = ls.login(user,pass);
			
			if(admin == null){
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
