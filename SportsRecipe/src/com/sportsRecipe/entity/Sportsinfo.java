package com.sportsRecipe.entity;

/**
 * Sportsinfo entity. @author MyEclipse Persistence Tools
 */

public class Sportsinfo implements java.io.Serializable {

	// Fields

	private String sportsId;
	private Userinfo userinfo;
	private String speed;
	private String pathLength;

	// Constructors

	/** default constructor */
	public Sportsinfo() {
	}

	/** full constructor */
	public Sportsinfo(String sportsId, Userinfo userinfo, String speed,
			String pathLength) {
		this.sportsId = sportsId;
		this.userinfo = userinfo;
		this.speed = speed;
		this.pathLength = pathLength;
	}

	// Property accessors

	public String getSportsId() {
		return this.sportsId;
	}

	public void setSportsId(String sportsId) {
		this.sportsId = sportsId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getSpeed() {
		return this.speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getPathLength() {
		return this.pathLength;
	}

	public void setPathLength(String pathLength) {
		this.pathLength = pathLength;
	}

}