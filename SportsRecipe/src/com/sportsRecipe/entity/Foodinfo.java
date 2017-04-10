package com.sportsRecipe.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Foodinfo entity. @author MyEclipse Persistence Tools
 */

public class Foodinfo implements java.io.Serializable {

	// Fields

	private String foodId;
	private String foodName;
	private String foodDescribe;
	private String level;
	private Set recipes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Foodinfo() {
	}

	/** minimal constructor */
	public Foodinfo(String foodId, String foodName, String foodDescribe,
			String level) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodDescribe = foodDescribe;
		this.level = level;
	}

	/** full constructor */
	public Foodinfo(String foodId, String foodName, String foodDescribe,
			String level, Set recipes) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodDescribe = foodDescribe;
		this.level = level;
		this.recipes = recipes;
	}

	// Property accessors

	public String getFoodId() {
		return this.foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodDescribe() {
		return this.foodDescribe;
	}

	public void setFoodDescribe(String foodDescribe) {
		this.foodDescribe = foodDescribe;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Set getRecipes() {
		return this.recipes;
	}

	public void setRecipes(Set recipes) {
		this.recipes = recipes;
	}

}