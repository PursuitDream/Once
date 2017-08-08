package com.rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rent.servlet.ConnectionFactory;
import com.rent.vo.AdminVO;

public class LoginDao {

	public AdminVO login(String user, String pass) {

		AdminVO admin = null;
		
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pre = conn.prepareStatement("SELECT * FROM tab_user WHERE login_name=? AND password=?");
			pre.setString(1, user);
			pre.setString(2, pass);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()){
				admin = new AdminVO();
				admin.setLoginName(rs.getString("login_name"));;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return admin;
	}

}
