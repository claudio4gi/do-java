package br.com.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Master {

	private String id;
	private String name;
	private Details details;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
