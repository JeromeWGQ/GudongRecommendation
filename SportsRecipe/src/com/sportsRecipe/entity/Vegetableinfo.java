package com.sportsRecipe.entity;

/**
 * Vegetableinfo entity. @author MyEclipse Persistence Tools
 */

public class Vegetableinfo implements java.io.Serializable {

	// Fields

	private String vegetableId;
	private String vegetableName;
	private Double vegetableCalorie;

	// Constructors

	/** default constructor */
	public Vegetableinfo() {
	}

	/** full constructor */
	public Vegetableinfo(String vegetableName, Double vegetableCalorie) {
		this.vegetableName = vegetableName;
		this.vegetableCalorie = vegetableCalorie;
	}

	// Property accessors

	public String getVegetableId() {
		return this.vegetableId;
	}

	public void setVegetableId(String vegetableId) {
		this.vegetableId = vegetableId;
	}

	public String getVegetableName() {
		return this.vegetableName;
	}

	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}

	public Double getVegetableCalorie() {
		return this.vegetableCalorie;
	}

	public void setVegetableCalorie(Double vegetableCalorie) {
		this.vegetableCalorie = vegetableCalorie;
	}

}