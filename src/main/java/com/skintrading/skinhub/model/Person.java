package com.skintrading.skinhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String email;
	private String password;
	// private SteamInfo steamInfo;

	public long getId() {
		return this.id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// public SteamInfo getSteamInfo() {
	// return steamInfo;
	// }

	// public void setSteamInfo(SteamInfo steamInfo) {
	// this.steamInfo = steamInfo;
	// }

}
