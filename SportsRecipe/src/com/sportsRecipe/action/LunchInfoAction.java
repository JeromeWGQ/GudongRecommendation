package com.sportsRecipe.action;

import com.sportsRecipe.service.LunchInfoService;

public class LunchInfoAction {
	private LunchInfoService lunchInfoService;

	public LunchInfoService getLunchInfoService() {
		return lunchInfoService;
	}

	public void setLunchInfoService(LunchInfoService lunchInfoService) {
		this.lunchInfoService = lunchInfoService;
	}

}
