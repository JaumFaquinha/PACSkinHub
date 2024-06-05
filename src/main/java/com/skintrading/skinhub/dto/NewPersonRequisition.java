package com.skintrading.skinhub.dto;

public class NewPersonRequisition {

	private String personName;
	private String personEmail;
	private String personPassword;
	// private SteamInfo steamInfo;


	public String getName() {
		return this.personName;
	}

	public void setName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return this.personEmail;
	}

	public void setEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPassword() {
		return this.personPassword;
	}

	public void setPassword(String personPassword) {
		this.personPassword = personPassword;
	}

	// public SteamInfo getSteamInfo() {
	// return steamInfo;
	// }

	// public void setSteamInfo(SteamInfo steamInfo) {
	// this.steamInfo = steamInfo;
	// }

}

    

