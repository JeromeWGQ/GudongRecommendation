package com.sportsRecipe.entity;

/**
 * Userprofile entity. @author MyEclipse Persistence Tools
 */

public class Userprofile implements java.io.Serializable {

	// Fields

	private String userid;
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

	// Constructors

	/** default constructor */
	public Userprofile() {
	}

	/** full constructor */
	public Userprofile(String nickname, String interest, String signature,
			String purpose, Double height, Double weight, Integer age,
			Integer sex, Double pweight, Integer pdays) {
		this.nickname = nickname;
		this.interest = interest;
		this.signature = signature;
		this.purpose = purpose;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.sex = sex;
		this.pweight = pweight;
		this.pdays = pdays;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getInterest() {
		return this.interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Double getPweight() {
		return this.pweight;
	}

	public void setPweight(Double pweight) {
		this.pweight = pweight;
	}

	public Integer getPdays() {
		return this.pdays;
	}

	public void setPdays(Integer pdays) {
		this.pdays = pdays;
	}

}