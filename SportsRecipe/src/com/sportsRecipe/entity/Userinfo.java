package com.sportsRecipe.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private String userId;
	private Role role;
	private String userName;
	private String password;
	private String goal;
	private Set sportsinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String userId, Role role, String userName, String password) {
		this.userId = userId;
		this.role = role;
		this.userName = userName;
		this.password = password;
	}

	/** full constructor */
	public Userinfo(String userId, Role role, String userName, String password,
			String goal, Set sportsinfos) {
		this.userId = userId;
		this.role = role;
		this.userName = userName;
		this.password = password;
		this.goal = goal;
		this.sportsinfos = sportsinfos;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Set getSportsinfos() {
		return this.sportsinfos;
	}

	public void setSportsinfos(Set sportsinfos) {
		this.sportsinfos = sportsinfos;
	}

}