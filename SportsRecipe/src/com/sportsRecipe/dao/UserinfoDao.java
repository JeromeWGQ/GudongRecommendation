package com.sportsRecipe.dao;

import com.sportsRecipe.entity.Userinfo;

public interface UserinfoDao {
	public Userinfo findUser(String userName);
}