package com.sportsRecipe.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.sportsRecipe.entity.Userimg;
import com.sportsRecipe.entity.Userlogininfo;
import com.sportsRecipe.service.UserImgService;
import com.sportsRecipe.service.UserlogininfoService;
import com.sportsRecipe.util.ResultUtils;

public class UserImgAction {
	private UserImgService userImgService;
	private UserlogininfoService userlogininfoService;
	private Userlogininfo data;
	private String username;
	private String imgbase64;
	private String length;
	private Double caloria;
	private Integer bupin;
	private Integer bufu;
	private Integer steps;
	private Double avgspeed;
	
	
	
	public void user_img_update() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "";
		
		data=userlogininfoService.findUser(username);
		if(data==null){
			status="0";
		}else{
			Userimg temp = new Userimg();
			temp = userImgService.findImg(data.getUserId());
			if(temp!=null){
				userImgService.delete(temp);
			}
			
			Userimg userImg = new Userimg();
			userImg.setUserid(data.getUserId());
			userImg.setImgbase64(imgbase64);
			userImgService.save(userImg);
			status="1";	
		}
		
		map.put("status", status);
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
	}
	
	public void user_img_get() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "";
		
		data=userlogininfoService.findUser(username);
		if(data==null){
			status="0";
		}
		else{
			Userimg userImg = new Userimg();
			userImg = userImgService.findImg(data.getUserId());
			List<Userimg> list = new ArrayList<Userimg>();
			list.add(userImg);
			status="1";
			map.put("json", list);
		}
		
		map.put("status", status);
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
	}
	

	public UserImgService getUserImgService() {
		return userImgService;
	}

	public void setUserImgService(UserImgService userImgService) {
		this.userImgService = userImgService;
	}


	public UserlogininfoService getUserlogininfoService() {
		return userlogininfoService;
	}


	public void setUserlogininfoService(UserlogininfoService userlogininfoService) {
		this.userlogininfoService = userlogininfoService;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getImgbase64() {
		return imgbase64;
	}


	public void setImgbase64(String imgbase64) {
		this.imgbase64 = imgbase64;
	}


	public Userlogininfo getData() {
		return data;
	}


	public void setData(Userlogininfo data) {
		this.data = data;
	}
	
}
