package com.sportsRecipe.dao;

import com.sportsRecipe.entity.Userprofile;

public interface UserProfileDao {

	void save(Userprofile userProfile);

	Userprofile findUser(String userId);

	void delete(Userprofile temp);

}
