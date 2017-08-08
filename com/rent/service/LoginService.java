package com.rent.service;

import com.rent.dao.LoginDao;
import com.rent.vo.AdminVO;

public class LoginService {

	public AdminVO login(String user, String pass) {
		
		return new LoginDao().login(user,pass);
	}

}
