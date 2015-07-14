package com.usertest.testapp.domains;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="users")
public class Users implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int USER_ID;
	@Column(name="username",unique=true)
	@NotBlank
	@Size(min=8, max=20)
	@Pattern(regexp="^\\w{8,}$",message="Username can only consists, letters and the undescore character.")
	private String username;
	@Column(name="password")
	@NotBlank(message="Password cannot be blank.")
	@Size(min=8, max=100, message="Password has to be between 6 and 100 characters long.")
	@Pattern(regexp="^\\S+$", message="Password cannot have space.")
	private String password;
	@Column(name="enabled", columnDefinition="bool default true")
	private boolean enabled = true;
	@Column(name="email")
	@NotBlank(message="Email cannot be blank.")
	@Email(message="Please re-enter the email.")
	private String email;
	@OneToOne(mappedBy="users",targetEntity=Authorities.class, orphanRemoval=true, fetch=FetchType.LAZY, optional=true, cascade=CascadeType.ALL)
	private Authorities authority;

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
	public Users() {

	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public Authorities getAuthority() {
		return authority;
	}
	public void setAuthority(Authorities authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [USER_ID=");
		builder.append(USER_ID);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", email=");
		builder.append(email);
//		builder.append(", authority=");
//		builder.append(authority);
		builder.append("]");
		return builder.toString();
	}

}
