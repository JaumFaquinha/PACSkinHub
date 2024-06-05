package com.skintrading.skinhub.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Skin {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String wearValue;
    private String skinMarketLink;
    private Double wearLevel; // Use the wrapper class for nullability.
    private Double price; // Use the wrapper class for nullability.
	private EquipmentType equipmentType;
    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;

   

	// Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id){
		this.id = id;
	}

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

    public LocalDateTime getCreationDate(){
		if(this.creationDate == null){
			this.creationDate = LocalDateTime.now();
		}

		return this.creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate){
		this.creationDate = creationDate;
	}

    public LocalDateTime getUpdatedDate(){
		if(this.updatedDate == null){
			this.updatedDate = LocalDateTime.now();
		}

		return this.updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate){
		this.updatedDate = updatedDate;
	}
}


// package com.skintrading.skinhub.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;

// @Entity
// public class Skin {
// 	@Id
// 	@GeneratedValue
// 	private Long id;
// 	private String name;
// 	private String wearValue;
// 	private String skinMarketLink;
// 	private float wearLevel;
// 	private float price; // Rever: Talvez criar classe de preço para calculo;

// 	public Long getId(){
// 		return this.id;
// 	}

// 	public String getName() {
// 		return name;
// 	}

// 	public void setName(String name) {
// 		this.name = name;
// 	}

// 	public String getWearValue() {
// 		return wearValue;
// 	}

// 	public void setWearValue(String wearValue) {
// 		this.wearValue = wearValue;
// 	}

// 	public float getWearLevel() {
// 		return wearLevel;
// 	}

// 	public String getSkinMarketLink() {
// 		return skinMarketLink;
// 	}

// 	public void setSkinMarketLink(String skinMarketLink) {
// 		this.skinMarketLink = skinMarketLink;
// 	}

// 	public void setWearLevel(float wearLevel) {
// 		this.wearLevel = wearLevel;
// 	}

// 	public float getPrice() {
// 		return price;
// 	}

// 	public void setPrice(float price) {
// 		this.price = price;
// 	}

// }
