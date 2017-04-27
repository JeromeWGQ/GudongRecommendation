package com.sportsRecipe.service;

import com.sportsRecipe.entity.Userprofile;

public interface UserProfileService {

	void save(Userprofile userProfile);

	Userprofile findUser(String userId);

	void delete(Userprofile temp);

}
