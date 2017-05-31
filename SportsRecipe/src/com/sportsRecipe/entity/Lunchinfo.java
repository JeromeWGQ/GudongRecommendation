package com.sportsRecipe.entity;

/**
 * Vegetableinfo entity. @author MyEclipse Persistence Tools
 */

public class Lunchinfo implements java.io.Serializable {

	// Fields

	private String lunchId;
	private String lunchName;
	private Double lunchCalorie;
	
	public String getLunchId() {
		return lunchId;
	}
	public void setLunchId(String lunchId) {
		this.lunchId = lunchId;
	}
	public String getLunchName() {
		return lunchName;
	}
	public void setLunchName(String lunchName) {
		this.lunchName = lunchName;
	}
	public Double getLunchCalorie() {
		return lunchCalorie;
	}
	public void setLunchCalorie(Double lunchCalorie) {
		this.lunchCalorie = lunchCalorie;
	}
	
	
    
	
}