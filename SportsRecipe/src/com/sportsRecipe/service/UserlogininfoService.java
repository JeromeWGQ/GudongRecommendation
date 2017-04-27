package com.sportsRecipe.service;

import com.sportsRecipe.entity.Userlogininfo;

public interface UserlogininfoService {
	public Userlogininfo findUser(String userName);
	
	public void save(Userlogininfo transientInstance);
}
