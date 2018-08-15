package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.House;
import com.yc.web.model.JsonModel;

public interface HouseBiz {
	
	/**
	 * 根据id查某个房子的信息
	 * @param house
	 * @return
	 */
	public House getHouseBean(House house);

	public boolean addHouse( House house);
	
	
	public boolean updateHouse(House house);
	
	public boolean delHouse(int id);
	
	public boolean delHouses(List<Integer> ids);
	
	public JsonModel<House> searchHouse(Map<String,Object>map);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
