package br.com.jccf.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Details {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
