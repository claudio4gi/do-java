package br.com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.example.model.Details;

@Repository
public interface DetailsRepository extends MongoRepository<Details, String> {

}
