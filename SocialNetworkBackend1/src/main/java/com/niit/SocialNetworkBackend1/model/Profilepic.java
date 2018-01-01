package com.niit.SocialNetworkBackend1.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Profilepic {
	
	@Id
	private String userName;
	@Lob //large object
	private byte[] image;
	


	@Override
	public String toString() {
		return "Profilepic [userName=" + userName + ", image=" + Arrays.toString(image) + "]";
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
