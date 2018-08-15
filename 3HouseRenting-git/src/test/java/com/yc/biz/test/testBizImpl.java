package com.yc.biz.test;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.House;
import com.yc.bean.HouseType;
import com.yc.bean.Street;
import com.yc.bean.User;
import com.yc.biz.DistrictBiz;
import com.yc.biz.HouseBiz;
import com.yc.biz.HouseTypeBiz;
import com.yc.biz.UserBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:beans.xml", "classpath:beans-dao.xml" }) // 告诉容器,
public class testBizImpl {
	
	@Resource(name="userBizImpl")
	private UserBiz userBiz;
	@Resource(name="houseBizImpl")
	private HouseBiz houseBiz;
	@Resource(name="houseTypeBizImpl")
	private HouseTypeBiz houseTypeBiz;
	@Resource(name="districtBizImpl")
	private DistrictBiz districtBiz;

	/**
	 * 根据id查用户
	 */
	@Test
	public void testUser(){
		System.out.println(userBiz.getUserById(1));
	}
	
	
	/**
	 * 查用户是否存在
	 */
	/*@Test
	public void testUser2(){
		User u=new User();
		u.setUsername("a");
		System.out.println(userBiz.validate(u));
	}*/
	
	/**
	 * 根据用户名和密码来查询用户
	 */
	@Test
	public void testLogin(){
		User u=new User();
		u.setPassword("a");
		u.setUsername("a");
		System.out.println(userBiz.login(u));
	}
	
	
	@Test//( 'yao','a','18374715691','a','1')
	public void testRegister(){
		User u=new User();
		u.setName("yao1");
		u.setPassword("a");
		u.setTelphone("18374714822");
		u.setUsername("a");
		u.setIsadmin("0");
		System.out.println(userBiz.register(u));
	}
	
	@Test//select title,type_id,STREET_ID,id from house 
	public void testHouseBean(){
		House house=new House();
		house.setId(1);
		System.out.println(houseBiz.getHouseBean(house));
	}
	
	
	@Test//select title,type_id,STREET_ID,id from house 
	public void testSearchHouse(){
		Map<String,Object> map=new HashMap<String,Object>();
		int pages=1;
		int pagesize=3;
		int start=(pages-1)*pagesize;//0
		map.put("start", start);//0
		map.put("pages",pages);//1
		map.put("pagesize", pagesize);//5
		System.out.println(houseBiz.searchHouse(map));
	}
	
	@Test
	public void testGetStreetByDistrictId(){
		System.out.println(districtBiz.getStreetByDistrictId(1004));
	}
	
	@Test
	public void testDoAdd(){
		
		House house=new House();
		 User user=new User();
		 user.setId(9);
		 house.setUser(user);
		 HouseType type=new HouseType();
		 type.setId(2);
		house.setType(type);
		house.setTitle("天字八号");
		house.setDescription("舒适+6");
		house.setPrice(7777.0);
		
		house.setFloorage(1999);
		house.setContact("18374715693");
		Street street=new Street();
		street.setId(1000);
		house.setStreet(street);
		System.out.println(houseBiz.addHouse(house));
		
	}
	
	@Test
	public void testDelhouse(){
		System.out.println(houseBiz.delHouse(11));
	}
	
	@Test
	public void testHouseList(){
		System.out.println(houseTypeBiz.getTypeList());
	}
	
	@Test
	public void testUpdate(){
		House house=new House();
		house.setTitle("地字二号");
		house.setId(26);
		User user=new User();
		user.setId(9);
		house.setUser(user);
		HouseType type=new HouseType();
		type.setId(2);
		house.setType(type);
		house.setDescription("舒适+6");
		house.setPrice(250.0);
		house.setFloorage(2000);
		house.setContact("147852369");
		Street street=new Street();
		street.setId(1000);
		house.setStreet(street);
		System.out.println(houseBiz.updateHouse(house));
	}
	
}
