package com.sportsRecipe.service.Impl;

import com.sportsRecipe.dao.SportsInfoDao;
import com.sportsRecipe.entity.Sportsinfo;
import com.sportsRecipe.entity.Userlogininfo;
import com.sportsRecipe.service.SportsInfoService;

public class SportsInfoServiceImpl implements SportsInfoService{
	
	private SportsInfoDao sportsInfoDao;

	public SportsInfoDao getSportsInfoDao() {
		return sportsInfoDao;
	}

	public void setSportsInfoDao(SportsInfoDao sportsInfoDao) {
		this.sportsInfoDao = sportsInfoDao;
	}

	@Override
	public Sportsinfo findSportsInfo(Userlogininfo data) {
		return sportsInfoDao.findSportsInfo(data);
	}

	@Override
	public void delete(Sportsinfo temp) {
		sportsInfoDao.delete(temp);
		
	}

	@Override
	public void addSportsInfo(Sportsinfo sportsInfo) {
		sportsInfoDao.addSportsInfo(sportsInfo);
		
	}

	@Override
	public void save(Sportsinfo sportsInfo) {
		sportsInfoDao.save(sportsInfo);
		
	}

}
