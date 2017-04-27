package com.sportsRecipe.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Userlogininfo entity. @author MyEclipse Persistence Tools
 */

public class Userlogininfo implements java.io.Serializable {

	// Fields

	private String userId;
	private String username;
	private String password;
	private Set sportsinfos = new HashSet(0);
	private Set sportsinfos_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userlogininfo() {
	}

	/** minimal constructor */
	public Userlogininfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Userlogininfo(String username, String password, Set sportsinfos,
			Set sportsinfos_1) {
		this.username = username;
		this.password = password;
		this.sportsinfos = sportsinfos;
		this.sportsinfos_1 = sportsinfos_1;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getSportsinfos() {
		return this.sportsinfos;
	}

	public void setSportsinfos(Set sportsinfos) {
		this.sportsinfos = sportsinfos;
	}

	public Set getSportsinfos_1() {
		return this.sportsinfos_1;
	}

	public void setSportsinfos_1(Set sportsinfos_1) {
		this.sportsinfos_1 = sportsinfos_1;
	}

}