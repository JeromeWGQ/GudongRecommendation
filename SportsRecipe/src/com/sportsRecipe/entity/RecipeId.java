package com.sportsRecipe.entity;

/**
 * RecipeId entity. @author MyEclipse Persistence Tools
 */

public class RecipeId implements java.io.Serializable {

	// Fields

	private Shopinfo shopinfo;
	private Foodinfo foodinfo;

	// Constructors

	/** default constructor */
	public RecipeId() {
	}

	/** full constructor */
	public RecipeId(Shopinfo shopinfo, Foodinfo foodinfo) {
		this.shopinfo = shopinfo;
		this.foodinfo = foodinfo;
	}

	// Property accessors

	public Shopinfo getShopinfo() {
		return this.shopinfo;
	}

	public void setShopinfo(Shopinfo shopinfo) {
		this.shopinfo = shopinfo;
	}

	public Foodinfo getFoodinfo() {
		return this.foodinfo;
	}

	public void setFoodinfo(Foodinfo foodinfo) {
		this.foodinfo = foodinfo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RecipeId))
			return false;
		RecipeId castOther = (RecipeId) other;

		return ((this.getShopinfo() == castOther.getShopinfo()) || (this
				.getShopinfo() != null && castOther.getShopinfo() != null && this
				.getShopinfo().equals(castOther.getShopinfo())))
				&& ((this.getFoodinfo() == castOther.getFoodinfo()) || (this
						.getFoodinfo() != null
						&& castOther.getFoodinfo() != null && this
						.getFoodinfo().equals(castOther.getFoodinfo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getShopinfo() == null ? 0 : this.getShopinfo().hashCode());
		result = 37 * result
				+ (getFoodinfo() == null ? 0 : this.getFoodinfo().hashCode());
		return result;
	}

}