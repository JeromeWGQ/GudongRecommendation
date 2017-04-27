package com.sportsRecipe.service.Impl;

import com.sportsRecipe.dao.UserImgDao;
import com.sportsRecipe.entity.Userimg;
import com.sportsRecipe.service.UserImgService;

public class UserImgServiceImpl implements UserImgService{
	private UserImgDao userImgDao;

	public UserImgDao getUserImgDao() {
		return userImgDao;
	}

	public void setUserImgDao(UserImgDao userImgDao) {
		this.userImgDao = userImgDao;
	}

	@Override
	public Userimg findImg(String userId) {
		return userImgDao.findImg(userId);
	}

	@Override
	public void delete(Userimg temp) {
		userImgDao.delete(temp);
		
	}

	@Override
	public void save(Userimg userImg) {
		userImgDao.save(userImg);
		
	}

}
