package com.sportsRecipe.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.sportsRecipe.entity.Userlogininfo;
import com.sportsRecipe.entity.Userprofile;
import com.sportsRecipe.service.UserProfileService;
import com.sportsRecipe.service.UserlogininfoService;
import com.sportsRecipe.util.ResultUtils;

public class UserProfileAction {
	private UserProfileService userProfileService;
	private UserlogininfoService userlogininfoService;
	
	private Userlogininfo data;
	private String username;
	private String nickname;
	private String interest;
	private String signature;
	private String purpose;
	private Double height;
	private Double weight;
	private Integer age;
	private Integer sex;
	private Double pweight;
	private Integer pdays;

	public void user_update() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "";
		
		data=userlogininfoService.findUser(username);
		
		if(data==null){
			status="0";
		}else{
			Userprofile temp = new Userprofile();
			temp=userProfileService.findUser(data.getUserId());
			if(temp!=null){
				userProfileService.delete(temp);
			}
			
			Userprofile userProfile = new Userprofile();
			userProfile.setUserid(data.getUserId());
			userProfile.setNickname(nickname);
			userProfile.setInterest(interest);
			userProfile.setSignature(signature);
			userProfile.setPurpose(purpose);
			userProfile.setHeight(height);
			userProfile.setWeight(weight);
			userProfile.setAge(age);
			userProfile.setSex(sex);
			userProfile.setPweight(pweight);
			userProfile.setPdays(pdays);
			
			userProfileService.save(userProfile);
			status="1";
		}
		map.put("status", status);
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
		
	}
	
	public void user_inf() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "";
		
		data=userlogininfoService.findUser(username);
		if(data==null){
			status="0";
		}
		else{
			Userprofile userProfile = new Userprofile();
			userProfile=userProfileService.findUser(data.getUserId());
			List<Userprofile> list = new ArrayList<Userprofile>();
			list.add(userProfile);
			status="1";
			map.put("json", list);
		}
		
		map.put("status", status);
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
		
	}
	
	
	
	public Userlogininfo getData() {
		return data;
	}

	public void setData(Userlogininfo data) {
		this.data = data;
	}

	public UserlogininfoService getUserlogininfoService() {
		return userlogininfoService;
	}

	public void setUserlogininfoService(UserlogininfoService userlogininfoService) {
		this.userlogininfoService = userlogininfoService;
	}

	public UserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getInterest() {
		return interest;
	}



	public void setInterest(String interest) {
		this.interest = interest;
	}



	public String getSignature() {
		return signature;
	}



	public void setSignature(String signature) {
		this.signature = signature;
	}



	public String getPurpose() {
		return purpose;
	}



	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}



	public Double getHeight() {
		return height;
	}



	public void setHeight(Double height) {
		this.height = height;
	}



	public Double getWeight() {
		return weight;
	}



	public void setWeight(Double weight) {
		this.weight = weight;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Integer getSex() {
		return sex;
	}



	public void setSex(Integer sex) {
		this.sex = sex;
	}



	public Double getPweight() {
		return pweight;
	}



	public void setPweight(Double pweight) {
		this.pweight = pweight;
	}



	public Integer getPdays() {
		return pdays;
	}



	public void setPdays(Integer pdays) {
		this.pdays = pdays;
	}



}
