package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.dao.BaseDao;

@Service
public class UserBizImpl implements UserBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao<User> baseDao;
	
	
	/**
	 * 根据id查用户
	 */
	@Override
	public User getUserById(Integer id) {
		User user=new User();
		user.setId(id);
		List<User> list= baseDao.findAll(user, "getUser");
		if( list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 注册
	 */
	@Override
	public boolean register(User user) {
		baseDao.save(user, "saveUser");
		return true;
	}

	/**
	 * 用户是否存在
	 */
	@Override
	public boolean validate(User user) {
		List<User> list=baseDao.findAll(user, "isUserExists");
		if( list!=null  &&   list.size()>0){
			return true;
		}
		return false;
		
	}

	

	/**
	 * 登录
	 */
	@Override
	public User login(User user) {
		List<User> list=baseDao.findAll(user, "getUserByLogin");
		if( user!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
