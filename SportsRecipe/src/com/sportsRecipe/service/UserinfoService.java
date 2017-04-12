package com.sportsRecipe.service;

import com.sportsRecipe.dao.UserinfoDao;
import com.sportsRecipe.entity.Userinfo;

public interface UserinfoService {
	public Userinfo findUser(String userName);
	
	public void save(Userinfo transientInstance);
}
