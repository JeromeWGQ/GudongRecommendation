package com.sportsRecipe.service.Impl;

import com.sportsRecipe.dao.UserProfileDao;
import com.sportsRecipe.entity.Userprofile;
import com.sportsRecipe.service.UserProfileService;

public class UserProfileServiceImpl implements UserProfileService{
	private UserProfileDao userProfileDao;

	public UserProfileDao getUserProfileDao() {
		return userProfileDao;
	}

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}

	@Override
	public void save(Userprofile userProfile) {
		userProfileDao.save(userProfile);
		
	}

	@Override
	public Userprofile findUser(String userId) {
		return userProfileDao.findUser(userId);
	}

	@Override
	public void delete(Userprofile temp) {
		userProfileDao.delete(temp);
		
	}
	
	

}
