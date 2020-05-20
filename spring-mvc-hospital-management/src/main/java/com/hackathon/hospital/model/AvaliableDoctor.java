package com.hackathon.hospital.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AvaliableDoctor {

	private Doctor doctors;
	private String total;
	private String date;

	public AvaliableDoctor(Doctor doctors, String total, String date) {
		this.doctors = doctors;
		this.total = total;
		this.date = date;
	}

	public Doctor getDoctors() {
		return doctors;
	}

	public void setDoctors(Doctor doctors) {
		this.doctors = doctors;
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
