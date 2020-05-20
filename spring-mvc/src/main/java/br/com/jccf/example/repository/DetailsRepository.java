package br.com.jccf.example.repository;

import br.com.jccf.example.model.Details;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends MongoRepository<Details, String> {

}
