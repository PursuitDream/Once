package com.rent.service;

import java.util.List;

import com.rent.dao.ShowCarListDao;
import com.rent.vo.CarVO;

public class ShowCarService {
	
	public List<CarVO> findCarList(int page,int pageSize){
		
		return new ShowCarListDao().findCarList(page,pageSize);
		
	}
	
	public int findCarListCount(){
		
		return new ShowCarListDao().findCarListCount();
		
	}

}
