package com.yc.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.House;
import com.yc.bean.User;
import com.yc.biz.HouseBiz;
import com.yc.web.model.JsonModel;
//@RestController
@Controller
public class HouseController {
	@Resource(name="houseBizImpl")
	private HouseBiz houseBiz;
	
	@RequestMapping("house_list.action")
	public String houseList( HttpServletRequest request, 
			    			 HttpSession session,
			    			 @RequestParam(name="pages")Integer pages,
			    			 @RequestParam(name="pagesize")Integer pagesize){
		Map<String,Object> map=new HashMap<String,Object>();
		Integer start=(pages-1)*pagesize;
		map.put("start", start);
		map.put("pages",pages);
		map.put("pagesize", pagesize);
		
		JsonModel jsonModel=houseBiz.searchHouse(map);
		
		request.setAttribute("jsonModel", jsonModel);
		session.setAttribute("list", jsonModel.getRows());
		return "showList";
	}
	
	
	@RequestMapping("/user/house_toAdd.action")
	public String houseToAdd(){
		return "add";
	}
	/*@RequestMapping("/user/house_toUpdate.action")
	public String houseToUpdate(){
		return "update";
	}*/

	@RequestMapping("/user/house_toUpdate.action")
	public String houseToUpdate(@RequestParam Integer id,HttpSession session,HttpServletRequest request){
		//查出id代表  House对象
		List<House> list=(List<House>) session.getAttribute("list");
		for(House h:list){
			if( h.getId().intValue()==id.intValue()){
				session.setAttribute("house", h);
				break;
			}
		}
		return "update";
	}
	
	@RequestMapping("/user/house_doUpdate.action")
	public String houseDoUpdate(House house,HttpSession session,HttpServletRequest request){
		System.out.println(house);
		User user=(User) session.getAttribute("user");
	    house.setUser(user);
		boolean result=houseBiz.updateHouse(house);
		return "list";
	}
	
	@RequestMapping("/user/house_doAdd.action")
	public String houseDoAdd(House house,HttpSession session){
		//System.out.println(house);
		User user=(User) session.getAttribute("user");
		user.setId(user.getId());
		house.setUser(user);
		boolean result=houseBiz.addHouse(house);
		return "list";
	}
	
	@RequestMapping("/user/house_del.action")
	@ResponseBody
	public JsonModel houseDel(@RequestParam Integer id){
		JsonModel jsonModel=new JsonModel();
		boolean r=houseBiz.delHouse(id);
		if( r  ){
			jsonModel.setCode(1);
		}else{
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
}
