package com.skintrading.skinhub.model;

import jakarta.annotation.Generated;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class BaseGun 
{
	@Id
	@GeneratedValue
	private long id;

	private String name;	
	private Skin skin;
	private EquipmentType equipmentType;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Skin getSkin() {
		return skin;
	}
	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	
	
}
