package com.yc.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bean.District;
import com.yc.biz.DistrictBiz;
import com.yc.web.model.JsonModel;

@RestController
public class districtListController {

	@Resource(name="districtBizImpl")
	private DistrictBiz districtBiz;
	
	@RequestMapping("houseDistrict.action")
	public JsonModel  houseList( HttpServletRequest request, HttpSession session){
		List<District> districtList=districtBiz.getDistrictList();
		session.setAttribute("districtList", districtList);
		
		JsonModel jsonModel=new JsonModel();
		jsonModel.setCode(1);
		jsonModel.setObj(districtList);
		return jsonModel;
	}

}
