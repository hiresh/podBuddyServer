package org.oracle.globalpay.repository;

import org.oracle.globalpay.model.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends MongoRepository<Query, String>{

	
	
}
