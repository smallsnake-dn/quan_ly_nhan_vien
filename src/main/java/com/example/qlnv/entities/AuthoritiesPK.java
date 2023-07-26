package com.example.qlnv.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthoritiesPK implements Serializable {
    private String username;
    private String authority;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
    
}
