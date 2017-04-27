package com.sportsRecipe.dao;

import com.sportsRecipe.entity.Userimg;

public interface UserImgDao {

	Userimg findImg(String userId);

	void delete(Userimg temp);

	void save(Userimg userImg);

}
