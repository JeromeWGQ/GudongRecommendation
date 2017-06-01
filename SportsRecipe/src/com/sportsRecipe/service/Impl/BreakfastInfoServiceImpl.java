package com.sportsRecipe.service.Impl;

import com.sportsRecipe.dao.BreakfastInfoDao;
import com.sportsRecipe.entity.Breakfastinfo;
import com.sportsRecipe.service.BreakfastInfoService;

public class BreakfastInfoServiceImpl implements BreakfastInfoService{
	private BreakfastInfoDao breakfastInfoDao;
	
	public BreakfastInfoDao getBreakfastInfoDao() {
		return breakfastInfoDao;
	}

	public void setBreakfastInfoDao(BreakfastInfoDao breakfastInfoDao) {
		this.breakfastInfoDao = breakfastInfoDao;
	}

	@Override
	public Breakfastinfo findBreakfast(String string) {
		return breakfastInfoDao.findBreakfast(string);
	}
	
	

}
