package com.hackathon.hospital.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hospital.model.Hospital;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {

}
