package com.sportsRecipe.dao;

import com.sportsRecipe.entity.Sportsinfo;
import com.sportsRecipe.entity.Userlogininfo;

public interface SportsInfoDao {

	Sportsinfo findSportsInfo(Userlogininfo data);

	void delete(Sportsinfo temp);

	void addSportsInfo(Sportsinfo sportsInfo);

	void save(Sportsinfo sportsInfo);

}
