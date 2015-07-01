package com.usertest.testapp.dao;

public class User {

	private String username;
	private String password;
	private boolean enabled = false;
	private String authority;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public User(String username, String password, boolean enabled,
			String authority, String email) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.email= email;
	}
	public User() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
