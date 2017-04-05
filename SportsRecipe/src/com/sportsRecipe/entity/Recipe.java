package com.sportsRecipe.entity;

/**
 * Recipe entity. @author MyEclipse Persistence Tools
 */

public class Recipe implements java.io.Serializable {

	// Fields

	private RecipeId id;

	// Constructors

	/** default constructor */
	public Recipe() {
	}

	/** full constructor */
	public Recipe(RecipeId id) {
		this.id = id;
	}

	// Property accessors

	public RecipeId getId() {
		return this.id;
	}

	public void setId(RecipeId id) {
		this.id = id;
	}

}