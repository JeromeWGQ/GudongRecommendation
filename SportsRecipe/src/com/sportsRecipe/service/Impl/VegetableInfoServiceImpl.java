package com.sportsRecipe.service.Impl;

import com.sportsRecipe.dao.VegetableInfoDao;
import com.sportsRecipe.entity.Vegetableinfo;
import com.sportsRecipe.service.VegetableInfoService;

public class VegetableInfoServiceImpl implements VegetableInfoService{
	private VegetableInfoDao vegetableInfoDao;

	public VegetableInfoDao getVegetableInfoDao() {
		return vegetableInfoDao;
	}

	public void setVegetableInfoDao(VegetableInfoDao vegetableInfoDao) {
		this.vegetableInfoDao = vegetableInfoDao;
	}

	@Override
	public Vegetableinfo findVegetable(String string) {
		return vegetableInfoDao.findVegetable(string);
	}
	
	

}
