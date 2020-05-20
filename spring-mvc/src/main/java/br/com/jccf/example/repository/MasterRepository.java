package br.com.jccf.example.repository;

import br.com.jccf.example.model.Master;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends MongoRepository<Master, String> {

}
