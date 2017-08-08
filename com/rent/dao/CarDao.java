package com.rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rent.po.CarPO;
import com.rent.servlet.ConnectionFactory;
import com.rent.vo.BrandVO;
import com.rent.vo.StoreVO;
import com.rent.vo.TypeVO;

public class CarDao {
	
	public List<BrandVO> findListBrand(){
		List<BrandVO> listBrand = new ArrayList<BrandVO>();
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pre = conn.prepareStatement("SELECT * FROM tab_brand");
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				BrandVO brand = new BrandVO();
				brand.setId(rs.getInt(1));
				brand.setName(rs.getString(2));
				listBrand.add(brand);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listBrand;
	}
	
	public List<StoreVO> findListStore(){
		List<StoreVO> listStore = new ArrayList<StoreVO>();
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pre = conn.prepareStatement("SELECT * FROM tab_store");
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				StoreVO store = new StoreVO();
				store.setId(rs.getInt(1));
				store.setName(rs.getString(2));
				listStore.add(store);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listStore;
	}
	
	public List<TypeVO> findTypeList(int bid){
		List<TypeVO> listType = new ArrayList<TypeVO>();
		
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pre = conn.prepareStatement("SELECT * FROM tab_type WHERE b_id=?");
			
			pre.setInt(1, bid);
			
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				TypeVO type = new TypeVO();
				type.setId(rs.getInt(1));
				type.setName(rs.getString(3));
				listType.add(type);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listType;
	}
	
	public void addCar(CarPO carPO){
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pre = conn.prepareStatement
					("INSERT INTO tab_car_info(brand_id,car_type_id,land_sign,hk_sign,color,store_id) VALUES(?,?,?,?,?,?)");
			pre.setObject(1, carPO.getBid());
			pre.setObject(2, carPO.getTid());
			pre.setObject(3, carPO.getLand_sign());
			pre.setObject(4, carPO.getHk_sign());
			pre.setObject(5, carPO.getColor());
			pre.setObject(6, carPO.getSid());
			
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}