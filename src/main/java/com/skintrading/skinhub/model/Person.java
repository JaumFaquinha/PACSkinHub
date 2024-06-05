package com.skintrading.skinhub.model;

import java.time.LocalDateTime;

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
    private LocalDateTime creationDate;	
    private LocalDateTime updatedDate;
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

	// public SteamInfo getSteamInfo() {
	// return steamInfo;
	// }

	// public void setSteamInfo(SteamInfo steamInfo) {
	// this.steamInfo = steamInfo;
	// }

}
