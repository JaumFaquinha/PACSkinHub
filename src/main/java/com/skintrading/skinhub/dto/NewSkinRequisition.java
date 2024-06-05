package com.skintrading.skinhub.dto;

import com.skintrading.skinhub.model.EquipmentType;
import com.skintrading.skinhub.model.WearLevelEnum;

public class NewSkinRequisition {


    private String name;
    private String wearValue;
    private String skinMarketLink;
    private Double wearLevel; // Use the wrapper class for nullability.
    private Double price; // Use the wrapper class for nullability.
	private EquipmentType equipmentType;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWearValue() {

		if(this.wearLevel != null)
		{
			if(this.wearLevel >= 0 && this.wearLevel <= 0.07)
			{
				this.wearValue = WearLevelEnum.FactoryNew.toString();
			}
			else if(this.wearLevel >= 0.7 && this.wearLevel <= 0.15)
			{
				this.wearValue = WearLevelEnum.MinimalWear.toString();
			}
			else if(this.wearLevel >= 0.15 && this.wearLevel <= 0.37)
			{
				this.wearValue = WearLevelEnum.FieldTested.toString();
			}
			else if(this.wearLevel >= 0.37 && this.wearLevel <= 0.44)
			{
				this.wearValue = WearLevelEnum.WellWorn.toString();
			}
			else if(this.wearLevel >= 0.44 && this.wearLevel <= 1.00)
			{
				this.wearValue = WearLevelEnum.BattleScarred.toString();
			}
		}
        return this.wearValue;
    }

    public void setWearValue(String wearValue) {
        this.wearValue = wearValue;
    }

    public String getSkinMarketLink() {
        return this.skinMarketLink;
    }

    public void setSkinMarketLink(String skinMarketLink) {
        this.skinMarketLink = skinMarketLink;
    }

    public Double getWearLevel() {
		
        return this.wearLevel;
    }

    public void setWearLevel(Double wearLevel) {
        this.wearLevel = wearLevel;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
	
	public EquipmentType getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}
}
    

