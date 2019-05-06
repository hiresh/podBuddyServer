package org.oracle.globalpay.repository;

import java.util.List;

import org.oracle.globalpay.model.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends MongoRepository<Query, String>{

	public List<Query> findByAuthor(String a);
	public Query findByQueryName(String name);
	public Query findBy_id(String id);
	
}
