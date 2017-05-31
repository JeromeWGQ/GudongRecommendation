package com.sportsRecipe.service.Impl;

import com.sportsRecipe.dao.LunchInfoDao;
import com.sportsRecipe.entity.Lunchinfo;

import com.sportsRecipe.service.LunchInfoService;

public class LunchInfoServiceImpl implements LunchInfoService{
	private LunchInfoDao lunchInfoDao;

	public LunchInfoDao getLunchInfoDao() {
		return lunchInfoDao;
	}

	public void setLunchInfoDao(LunchInfoDao lunchInfoDao) {
		this.lunchInfoDao = lunchInfoDao;
	}

	@Override
	public Lunchinfo findLunch(String string) {
		return lunchInfoDao.findLunch(string);
	}
	
	

}
