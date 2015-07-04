package com.usertest.testapp.domains;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="authorities")
public class Authorities implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="authoritiesId")
	private int authoritiesId;
	@Column(name="authority")
	private String authority;
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="usernameFK",referencedColumnName="username")
	private Users users;
	public int getAuthoritiesId() {
		return authoritiesId;
	}
	public void setAuthoritiesId(int authoritiesId) {
		this.authoritiesId = authoritiesId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Authorities(String authority, Users users) {
		super();
		this.authority = authority;
		this.users = users;
	}
	public Authorities() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Authorities [authoritiesId=");
		builder.append(authoritiesId);
		builder.append(", authority=");
		builder.append(authority);
		builder.append("]");
		return builder.toString();
	}
}
