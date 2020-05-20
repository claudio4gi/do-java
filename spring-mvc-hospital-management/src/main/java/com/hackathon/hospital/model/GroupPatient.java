package com.hackathon.hospital.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GroupPatient {

	private Patient patient;
	private String total;
	private String date;

	public GroupPatient(Patient patient, String total, String date) {
		this.patient = patient;
		this.total = total;
		this.date = date;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
