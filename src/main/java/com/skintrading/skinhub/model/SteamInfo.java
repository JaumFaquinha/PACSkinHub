package com.skintrading.skinhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SteamInfo
{
	//Todo Inserir propriedades

	@Id
	@GeneratedValue
	private Long id;
	private String steamProfileName;
	private String steamTradeLink;
	private String steamProfileLink;
	private String steamInventoryLink;
	private boolean isBanned;
	
	//Por enquanto não será usado pois será feito primeiramente com um loggin normal
	
	public Long getId(){
		return this.id;
	}

	public String getSteamName()
	{
		return steamProfileName;
	}
	
	public void setSteamName(String steamProfileName)
	{
		this.steamProfileName = steamProfileName;
	}
	
	public String getSteamTradeLink()
	{
		return steamTradeLink;
	}
	
	public void setSteamTradeLink(String steamTradeLink)
	{
		this.steamTradeLink = steamTradeLink;
	}
	
	public String getSteamProfileLink()
	{
		return steamProfileLink;
	}
	
	public void setSteamProfileLink(String steamProfileLink)
	{
		this.steamProfileLink = steamProfileLink;
	}
	
	public String getSteamInventoryLink()
	{
		return steamInventoryLink;
	}
	
	public void setSteamInventoryLink(String steamInventoryLink)
	{
		this.steamInventoryLink = steamInventoryLink;
	}
	
	public boolean isBanned()
	{
		return isBanned;
	}
	
	public void setBanned(boolean isBanned)
	{
		this.isBanned = isBanned;
	}
	
}
