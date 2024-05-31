package com.skintrading.skinhub.model;

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


	public String getName()
	{
		return this.name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public Skin getSkin() 
	{
		return this.skin;
	}
	public void setSkin(Skin skin) 
	{
		this.skin = skin;
	}

	public EquipmentType getEquipmentType()
	{
		return this.equipmentType;
	}
	public void setEquipmentType(EquipmentType equipmentType)
	{
		this.equipmentType = equipmentType;
	}

	
	
}
