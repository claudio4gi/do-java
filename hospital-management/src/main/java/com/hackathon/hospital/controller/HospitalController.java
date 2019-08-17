package com.hackathon.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackathon.hospital.model.AvaliableDoctor;
import com.hackathon.hospital.model.Coordinate;
import com.hackathon.hospital.model.Doctor;
import com.hackathon.hospital.model.GroupPatient;
import com.hackathon.hospital.model.Hospital;
import com.hackathon.hospital.model.Patient;
import com.hackathon.hospital.model.Queue;
import com.hackathon.hospital.repository.HospitalRepository;

@Component
public class HospitalController {

	@Autowired
	private HospitalRepository hospitalRepository;

	public void save() {
		List<String> tags = new ArrayList<>();
		tags.add("tag 1");
		tags.add("tag 2");

		Hospital hospital = new Hospital();
		hospital.setAddress("addres");
		hospital.setCoordinates(new Coordinate("latitude", "longitude"));
		hospital.setWatingTime("time");
		hospital.setAvaliableDoctors(new AvaliableDoctor(new Doctor("ex'peciality"), "total", "date"));
		hospital.setTags(tags);
		hospital.setQueue(new Queue(new GroupPatient(new Patient("age", "emergency"), "total", "date")));

		hospitalRepository.save(hospital);
	}

}
