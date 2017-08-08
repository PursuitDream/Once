package com.rent.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.rent.po.CarPO;
import com.rent.service.CarService;
import com.rent.service.ShowCarService;
import com.rent.vo.BrandVO;
import com.rent.vo.CarVO;
import com.rent.vo.StoreVO;
import com.rent.vo.TypeVO;

public class CarAction {
	
	private List<BrandVO> listBrand;
	private List<StoreVO> listStore;
	private int page;
	private int pageSize;
	private List<CarVO> listCar;
	private int totalPage;
	private CarPO carPO;
	private int bid;
	
	
	public String showCar(){
		
		try {
			
			CarService cs = new CarService();
			
			listBrand = cs.findListBrand();
			listStore = cs.findListStore();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "showCar";
	}

	public String ajaxType(){
		
		try {
			System.out.println(bid);
			CarService cs = new CarService();
			
			List<TypeVO> listType = cs.findTypeList(bid);
			
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/html;charset=utf-8");
			String str = JSON.toJSONString(listType);
			PrintWriter pw = resp.getWriter();
			pw.write(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String findCarList(){
		
		try {
			System.out.println(page + ":" + pageSize);
			ShowCarService carService = new ShowCarService();
			listCar = carService.findCarList(page, pageSize);
			
			int total = carService.findCarListCount();
			
			if(total%pageSize == 0){
				totalPage = total/pageSize;
			}else{
				totalPage = total/pageSize + 1 ;
			}
			System.out.println(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "car_list2";
	}
	
	public String addCar(){
		
		try {
			
			CarService cs = new CarService();
			cs.addCar(carPO);
			page = 1;
			pageSize = 10;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "car_list1";
	}
	
	public List<BrandVO> getListBrand() {
		return listBrand;
	}

	public List<StoreVO> getListStore() {
		return listStore;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<CarVO> getListCar() {
		return listCar;
	}

	public void setListCar(List<CarVO> listCar) {
		this.listCar = listCar;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public CarPO getCarPO() {
		return carPO;
	}

	public void setCarPO(CarPO carPO) {
		this.carPO = carPO;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
}
