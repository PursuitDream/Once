package com.rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rent.servlet.ConnectionFactory;
import com.rent.vo.CarVO;

public class ShowCarListDao {
	
	public List<CarVO> findCarList(int page,int pageSize) {
		List<CarVO> listCar = null;
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pre = conn.prepareStatement
					("SELECT c.*,s.name sname,t.name tname,b.name bname FROM tab_car_info c,tab_brand b,tab_type t,tab_store s WHERE c.brand_id = b.id AND c.car_type_id = t.id AND c.store_id=s.id  order by id desc limit ?,?");
			pre.setInt(1, (page-1)*pageSize);
			pre.setInt(2, pageSize);
			System.out.println(page);
			System.out.println(pageSize);
			ResultSet rs = pre.executeQuery();
			listCar = new ArrayList<CarVO>();
			while(rs.next()){
				 CarVO car = new CarVO();
				 car.setBname(rs.getString("bname"));
				 car.setTname(rs.getString("tname"));
				 car.setSname(rs.getString("sname"));
				 car.setHk_sign(rs.getString("hk_sign"));
				 car.setLand_sign(rs.getString("land_sign"));
				 car.setColor(rs.getString("color"));
				 car.setId(rs.getInt("id"));
				 listCar.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCar;
	}
	
	public int findCarListCount(){
		int total = 0;
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pre1 = conn.prepareStatement("SELECT COUNT(*) total FROM tab_car_info");
			ResultSet rs1 = pre1.executeQuery();
			if(rs1.next()){
				total = rs1.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(total);
		return total;
	}

}
