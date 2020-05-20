package com.hackathon.hospital.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Doctor {

	private String expeciality;

	public Doctor(String expeciality) {
		this.expeciality = expeciality;
	}

	public String getExpeciality() {
		return expeciality;
	}

	public void setExpeciality(String expeciality) {
		this.expeciality = expeciality;
	}

}
