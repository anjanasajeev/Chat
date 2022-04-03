package com.genesys.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name ="messages")
@Table(name ="messages")
public class PSVChatMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int message_id;

	@Column(name = "content")
	private String content;
	
	@Column(name = "username")
	private String sender;
	
	@Column(name = "emp_id")
	private String employeeID;
	
	private MessageType type;	

	public enum MessageType {
		CHAT, LEFT, JOIN
	}
	
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

}
