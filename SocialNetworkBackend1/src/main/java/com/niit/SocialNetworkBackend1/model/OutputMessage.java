package com.niit.SocialNetworkBackend1.model;

import java.util.Date;

public class OutputMessage extends Message{
	
	private Date time;
	
	public OutputMessage(Message msg, Date time) {
		super(msg.getId(), msg.getMessage());
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	

}
