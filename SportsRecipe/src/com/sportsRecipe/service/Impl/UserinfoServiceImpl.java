package com.sportsRecipe.service.Impl;

import com.sportsRecipe.dao.UserinfoDao;
import com.sportsRecipe.entity.Userinfo;
import com.sportsRecipe.service.UserinfoService;

public class UserinfoServiceImpl implements UserinfoService {
	private UserinfoDao userinfoDao;
	
	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	@Override
	public Userinfo findUser(String userName) {
		// TODO Auto-generated method stub
		return userinfoDao.findUser(userName);
	}

}
