package com.hackathon.hospital.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {

	private String age;
	private String emergency;

	public Patient(String age, String emergency) {
		this.age = age;
		this.emergency = emergency;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

}
