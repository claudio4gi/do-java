package com.hackathon.hospital.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Queue {

	private GroupPatient groupPatients;

	public Queue(GroupPatient groupPatients) {
		this.groupPatients = groupPatients;
	}

	public GroupPatient getGroupPatients() {
		return groupPatients;
	}

	public void setGroupPatients(GroupPatient groupPatients) {
		this.groupPatients = groupPatients;
	}

}
