package com.sportsRecipe.service;

import com.sportsRecipe.entity.Userimg;

public interface UserImgService {

	Userimg findImg(String userId);

	void delete(Userimg temp);

	void save(Userimg userImg);

}
