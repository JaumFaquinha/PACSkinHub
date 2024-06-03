package com.skintrading.skinhub.model;

import jakarta.persistence.Entity;

@Entity
public class Skin {
	private String name;
	private String wearValue;
	private String skinMarketLink;
	private float wearLevel;
	private float price; // Rever: Talvez criar classe de preço para calculo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWearValue() {
		return wearValue;
	}

	public void setWearValue(String wearValue) {
		this.wearValue = wearValue;
	}

	public String getSkinMarketLink() {
		return skinMarketLink;
	}

	public void setSkinMarketLink(String skinMarketLink) {
		this.skinMarketLink = skinMarketLink;
	}

	public void setWearLevel(float wearLevel) {
		this.wearLevel = wearLevel;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
