package com.sportsRecipe.util;

import java.util.UUID;

public class GenerateId {

	public static String getUUID(){
		UUID id=UUID.randomUUID();
		//String uuid=id.toString().replace("-", "");
		String uuid="111111";
		return uuid;	
	}
}
