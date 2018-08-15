package com.yc.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.User;
import com.yc.biz.HouseTypeBiz;
import com.yc.biz.UserBiz;
import com.yc.web.model.JsonModel;

@Api(value="/user",tags="用户模块")
//@Controller
@RestController  //类注解  同时使用@Controller 和 @Response
public class UserController {
	@Resource(name="userBizImpl")
	private UserBiz userBiz;
	
	@ApiOperation(value="注册",notes="注册")
	@RequestMapping(value="/user_register.action")
	public JsonModel register(User user){
		JsonModel jm=new JsonModel();
		boolean result=userBiz.register(user);
		if( result){
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		return jm;
	}
	
	/*@RequestMapping(value="user/user_logout.action")
	public ModelAndView logout(HttpSession session){
		
		ModelAndView mav=new ModelAndView();
		session.removeAttribute("user");
		mav.setViewName("login");
		return mav;
		
	}*/
	//重定向
	@ApiOperation(value="安全退出",notes="安全退出")
	@RequestMapping(value="user/user_logout.action")
	public void logout(HttpSession session,HttpServletResponse response){
		session.removeAttribute("user");
		try {
			response.sendRedirect("../index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@ApiOperation(value="用户登录",notes="用户登录")
	
	@ApiImplicitParam(name="User",value="User",required=true,dataType="User")
	@RequestMapping(value="/user_login.action")
	//因为登录后是要直接到list.jsp页显示，且login.jsp页是通过submit提交，即不支持ajax,不用
	//回送json数据，而是回送一个页面的名字，这样springmvc的视图解析器就可以运行了
	public ModelAndView login(User user,HttpServletRequest request,HttpSession session){
		//为什么有上参数？ 因为name,password是User对象有的，但zccode是在类中没有的。所以要通过 request取
		//另外，rand是存在session中 所以还要HttpSession
		
		ModelAndView mav=new ModelAndView();
		
		String zccode=request.getParameter("zccode");
		String rand=session.getAttribute("rand").toString();
		if( !rand.equals(zccode)){
			request.setAttribute("errormsg", "验证码错误");
		}else{
			user=userBiz.login(user);
			if(user!=null){
				session.setAttribute("user", user);
				mav.setViewName("list");
				return mav;
			}else{
				request.setAttribute("errormsg", "用户名或密码错误");
			}
		}
		mav.setViewName("login");
		return mav;
	}

}
