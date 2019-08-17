package com.hackathon.hospital.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Coordinate {

	private String latitude;
	private String longitude;

	public Coordinate(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
