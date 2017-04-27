package com.sportsRecipe.dao;

import com.sportsRecipe.entity.Userlogininfo;

public interface UserlogininfoDao {
	public Userlogininfo findUser(String userName);

	public void save(Userlogininfo transientInstance);

}
