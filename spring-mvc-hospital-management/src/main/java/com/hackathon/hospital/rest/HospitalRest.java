package com.hackathon.hospital.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hospital.api.RestApi;
import com.hackathon.hospital.controller.HospitalController;

@RestController
@RequestMapping("/hospital")
public class HospitalRest {

	@Autowired
	private HospitalController hospitalController;

	@RequestMapping(path = "/dfd", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String save() {
		hospitalController.save();
		return "ok";
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String sensor() {
		try {
			new RestApi().doGET("", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

}
