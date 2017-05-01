package com.sportsRecipe.service;

import com.sportsRecipe.entity.Sportsinfo;
import com.sportsRecipe.entity.Userlogininfo;

public interface SportsInfoService {

	Sportsinfo findSportsInfo(Userlogininfo data);

	void delete(Sportsinfo temp);

	void addSportsInfo(Sportsinfo sportsInfo);

	void save(Sportsinfo sportsInfo);

}
