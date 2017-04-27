package com.sportsRecipe.service.Impl;

import com.sportsRecipe.dao.UserlogininfoDao;
import com.sportsRecipe.entity.Userlogininfo;
import com.sportsRecipe.service.UserlogininfoService;

public class UserlogininfoServiceImpl implements UserlogininfoService {
	private UserlogininfoDao userlogininfoDao;
	
	public void setUserlogininfoDao(UserlogininfoDao userlogininfoDao) {
		this.userlogininfoDao = userlogininfoDao;
	}

	@Override
	public Userlogininfo findUser(String userName) {
		return userlogininfoDao.findUser(userName);
	}
	
	public void save(Userlogininfo transientInstance){
		userlogininfoDao.save(transientInstance);
	}

}
