package com.usertest.testapp.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
@Table(name="UserDetails")
public class Details implements Serializable{
	@Transient
	Logger logger = LoggerFactory.getLogger(Details.class);
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int detailsId;
	
	@Column(name="User_Email")
	@Email
	private String emailAddress;
	
	@OneToOne(orphanRemoval=true, fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="UserFk")
	private User user;

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Details [detailsId=" + detailsId + ", emailAddress="
				+ emailAddress + "]";
				//+ emailAddress + ", user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
