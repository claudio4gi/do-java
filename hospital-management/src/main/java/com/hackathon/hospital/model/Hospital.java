package com.hackathon.hospital.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hospital {

	private String address;
	private Coordinate coordinates;
	private String watingTime;
	private AvaliableDoctor avaliableDoctors;
	private List<String> tags;
	private Queue queue;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Coordinate getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}

	public String getWatingTime() {
		return watingTime;
	}

	public void setWatingTime(String watingTime) {
		this.watingTime = watingTime;
	}

	public AvaliableDoctor getAvaliableDoctors() {
		return avaliableDoctors;
	}

	public void setAvaliableDoctors(AvaliableDoctor avaliableDoctors) {
		this.avaliableDoctors = avaliableDoctors;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

}
