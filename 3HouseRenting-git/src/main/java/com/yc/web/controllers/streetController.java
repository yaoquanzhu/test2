package com.yc.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.biz.DistrictBiz;
import com.yc.web.model.JsonModel;

@RestController
public class streetController {

	@Resource(name="districtBizImpl")
	private DistrictBiz districtBiz;
	
	@RequestMapping("street_list.action")
	public JsonModel street_list(District district){
		List<Street> list=this.districtBiz.getStreetByDistrictId(district.getId());
		JsonModel jsonModel=new JsonModel();
		jsonModel.setRows(list);//jsonMOdel.setObj(list)
		return jsonModel;
	}
}





































