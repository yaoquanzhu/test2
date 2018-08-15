package com.yc.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bean.HouseType;
import com.yc.biz.HouseTypeBiz;
import com.yc.web.model.JsonModel;

@RestController
public class houseTypeListController {

	@Resource(name="houseTypeBizImpl")
	private HouseTypeBiz houseTypeBiz;
	
	@RequestMapping("houseType.action")
	public JsonModel  houseList( HttpServletRequest request, HttpSession session){
		List<HouseType> houseTypeList=houseTypeBiz.getTypeList();
	     session.setAttribute("houseTypeList", houseTypeList);
		
		//System.out.println(houseTypeList);
		JsonModel jm=new JsonModel();
		jm.setCode(1);
		jm.setObj(houseTypeList);
		return jm;
	}

}
