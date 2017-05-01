package com.sportsRecipe.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

import com.sportsRecipe.entity.Sportsinfo;
import com.sportsRecipe.entity.Userlogininfo;
import com.sportsRecipe.entity.Userprofile;
import com.sportsRecipe.entity.Vegetableinfo;
import com.sportsRecipe.service.SportsInfoService;
import com.sportsRecipe.service.UserProfileService;
import com.sportsRecipe.service.UserlogininfoService;
import com.sportsRecipe.service.VegetableInfoService;
import com.sportsRecipe.util.GenerateId;
import com.sportsRecipe.util.ResultUtils;

public class SportsInfoAction {
	private SportsInfoService sportsInfoService;
	private UserlogininfoService userlogininfoService;
	private UserProfileService userProfileService;
	private VegetableInfoService vegetableInfoService;
	private Userlogininfo data;
	private Userprofile userProfile;
	private Vegetableinfo vegetableinfo1;
	private Vegetableinfo vegetableinfo2;
	private Vegetableinfo vegetableinfo3;
	private String username;
	private String length;
	private Double caloria;
	

	private Integer bupin;
	private Integer bufu;
	private Integer steps;
	private Double avgspeed;

	public void sport_upload() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "";

		data=userlogininfoService.findUser(username);
		if(data==null){
			status="0";
		}else{
			Sportsinfo temp = new Sportsinfo();
			temp = sportsInfoService.findSportsInfo(data);
			if(temp!=null){
				sportsInfoService.delete(temp);
			}

			Sportsinfo sportsInfo = new Sportsinfo();
			String id = GenerateId.getUUID();
			sportsInfo.setSportsId(id.substring(id.length()-20, id.length()));
			sportsInfo.setUserid(data.getUserId());
			sportsInfo.setLength(length);
			sportsInfo.setCaloria(caloria);
			sportsInfo.setBupin(bupin);
			sportsInfo.setBufu(bufu);
			sportsInfo.setSteps(steps);
			sportsInfo.setAvgspeed(avgspeed);
			sportsInfoService.save(sportsInfo);

			userProfile = userProfileService.findUser(data.getUserId());

			//73-98行 热量算法！ 
			Double currentWeight = userProfile.getWeight();
			Double goalWeight = userProfile.getPweight();
			Double subtractWeight = currentWeight - goalWeight;
			Double subtractCaloria = subtractWeight*7700;
			Double subtractCaloriaPerDay = subtractCaloria/userProfile.getPdays();
			Double BMR = currentWeight*24;
			Double REE = BMR*1.1;
			Double absorbCaloriaPerDay = REE*2-subtractCaloriaPerDay;
			System.out.println(absorbCaloriaPerDay*1000);

			HashSet<String> set = getThreeId();
			List<String> result = new ArrayList<String>(set);

			while(true){
				vegetableinfo1 = vegetableInfoService.findVegetable(result.get(0));
				vegetableinfo2 = vegetableInfoService.findVegetable(result.get(1));
				vegetableinfo3 = vegetableInfoService.findVegetable(result.get(2));
				System.out.println(vegetableinfo1.getVegetableCalorie());
				System.out.println(vegetableinfo2.getVegetableCalorie());
				System.out.println(vegetableinfo3.getVegetableCalorie());
				if((vegetableinfo1.getVegetableCalorie()+vegetableinfo2.getVegetableCalorie()+vegetableinfo3.getVegetableCalorie())<(absorbCaloriaPerDay)){
					break;
				}
				
			}
		}
		map.put("vegetable1", vegetableinfo1.getVegetableName());
		map.put("vegetable2", vegetableinfo2.getVegetableName());
		map.put("vegetable3", vegetableinfo3.getVegetableName());
        status="1";
		map.put("status", status);
		ResultUtils.toJson(ServletActionContext.getResponse(), map);

	}

	//从vegetable表20个id中随机抽取三个数
	public static HashSet<String> getThreeId(){
		int arr[] = new int[10];
		Random rand  =new Random();
		HashSet<String> set = new HashSet();

		while(set.size()<=2)
		{
			set.add(String.valueOf(rand.nextInt(20)+1));
		}
		System.out.println(set);
		return set;
	}

	public SportsInfoService getSportsInfoService() {
		return sportsInfoService;
	}



	public void setSportsInfoService(SportsInfoService sportsInfoService) {
		this.sportsInfoService = sportsInfoService;
	}



	public UserlogininfoService getUserlogininfoService() {
		return userlogininfoService;
	}

	public void setUserlogininfoService(UserlogininfoService userlogininfoService) {
		this.userlogininfoService = userlogininfoService;
	}

	public Userlogininfo getData() {
		return data;
	}

	public void setData(Userlogininfo data) {
		this.data = data;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Double getCaloria() {
		return caloria;
	}

	public void setCaloria(Double caloria) {
		this.caloria = caloria;
	}

	public Integer getBupin() {
		return bupin;
	}

	public void setBupin(Integer bupin) {
		this.bupin = bupin;
	}

	public Integer getBufu() {
		return bufu;
	}

	public void setBufu(Integer bufu) {
		this.bufu = bufu;
	}

	public Integer getSteps() {
		return steps;
	}

	public void setSteps(Integer steps) {
		this.steps = steps;
	}

	public Double getAvgspeed() {
		return avgspeed;
	}

	public void setAvgspeed(Double avgspeed) {
		this.avgspeed = avgspeed;
	}



	public UserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}



	public Userprofile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(Userprofile userProfile) {
		this.userProfile = userProfile;
	}
	
	public VegetableInfoService getVegetableInfoService() {
		return vegetableInfoService;
	}

	public void setVegetableInfoService(VegetableInfoService vegetableInfoService) {
		this.vegetableInfoService = vegetableInfoService;
	}

	public Vegetableinfo getVegetableinfo1() {
		return vegetableinfo1;
	}

	public void setVegetableinfo1(Vegetableinfo vegetableinfo1) {
		this.vegetableinfo1 = vegetableinfo1;
	}

	public Vegetableinfo getVegetableinfo2() {
		return vegetableinfo2;
	}

	public void setVegetableinfo2(Vegetableinfo vegetableinfo2) {
		this.vegetableinfo2 = vegetableinfo2;
	}

	public Vegetableinfo getVegetableinfo3() {
		return vegetableinfo3;
	}

	public void setVegetableinfo3(Vegetableinfo vegetableinfo3) {
		this.vegetableinfo3 = vegetableinfo3;
	}





}
