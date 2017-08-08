package com.rent.service;

import java.util.List;

import com.rent.dao.CarDao;
import com.rent.dao.ShowCarListDao;
import com.rent.po.CarPO;
import com.rent.vo.BrandVO;
import com.rent.vo.CarVO;
import com.rent.vo.StoreVO;
import com.rent.vo.TypeVO;

public class CarService {
	
	public List<BrandVO> findListBrand(){
		return new CarDao().findListBrand();
	}
	
	public List<StoreVO> findListStore(){
		return new CarDao().findListStore();
	}
	
	public List<TypeVO> findTypeList(int bid){
		return new CarDao().findTypeList(bid);
	}
	
	public List<CarVO> findCarList(int page,int pageSize){
		return new ShowCarListDao().findCarList(page, pageSize);
	}
	
	public int findCarListCount(){
		return new ShowCarListDao().findCarListCount();
	}

	public void addCar(CarPO carPO){

		new CarDao().addCar(carPO);
		
	}
	
}
