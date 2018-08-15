package com.yc.web.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.District;
import com.yc.bean.HouseType;
import com.yc.biz.DistrictBiz;
import com.yc.biz.HouseTypeBiz;
/**
 * 当servlet容器一启动就会加载这个类
 * @author ADMIN
 *
 */
public class InitListener implements ServletContextListener {
	private ApplicationContext ac;
	
	public InitListener() {
	}

	public void contextInitialized(ServletContextEvent sce) {
		//取application
		ServletContext application=sce.getServletContext();
		//工具类：Tomcat启动时  -> 加载整个应用程序中 的bean ioc -> di  -> context -> 存到application
		//利用spring提交的WebApplicationContextUtils类来获取spring容器
		ac=WebApplicationContextUtils.getWebApplicationContext(application);
		HouseTypeBiz typeBiz=(HouseTypeBiz) ac.getBean("houseTypeBizImpl");
		List<HouseType> houseTypeList=typeBiz.getTypeList();
		application.setAttribute("houseTypeList", houseTypeList);
		DistrictBiz districtBiz=(DistrictBiz) ac.getBean("districtBizImpl");
		List<District> districtList=districtBiz.getDistrictList();
		application.setAttribute("districtList", districtList);

	}

	
	public void contextDestroyed(ServletContextEvent sce) {
		

	}


}
