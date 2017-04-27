package com.sportsRecipe.entity;

/**
 * Userimg entity. @author MyEclipse Persistence Tools
 */

public class Userimg implements java.io.Serializable {

	// Fields

	private String userid;
	private String imgbase64;

	// Constructors

	/** default constructor */
	public Userimg() {
	}

	/** full constructor */
	public Userimg(String imgbase64) {
		this.imgbase64 = imgbase64;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getImgbase64() {
		return this.imgbase64;
	}

	public void setImgbase64(String imgbase64) {
		this.imgbase64 = imgbase64;
	}

}