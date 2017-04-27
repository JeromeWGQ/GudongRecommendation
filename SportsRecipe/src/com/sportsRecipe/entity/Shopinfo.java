package com.sportsRecipe.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Shopinfo entity. @author MyEclipse Persistence Tools
 */

public class Shopinfo implements java.io.Serializable {

	// Fields

	private String shopId;
	private String shopName;
	private String shopAddress;
	private Set recipes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shopinfo() {
	}

	/** minimal constructor */
	public Shopinfo(String shopId, String shopName, String shopAddress) {
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}

	/** full constructor */
	public Shopinfo(String shopId, String shopName, String shopAddress,
			Set recipes) {
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.recipes = recipes;
	}

	// Property accessors

	public String getShopId() {
		return this.shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return this.shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Set getRecipes() {
		return this.recipes;
	}

	public void setRecipes(Set recipes) {
		this.recipes = recipes;
	}

}