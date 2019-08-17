package br.com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.example.model.Master;

@Repository
public interface MasterRepository extends MongoRepository<Master, String> {

}
