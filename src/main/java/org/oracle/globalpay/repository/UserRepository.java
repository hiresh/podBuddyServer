package org.oracle.globalpay.repository;

import java.util.List;

import org.oracle.globalpay.model.Team;
import org.oracle.globalpay.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	public List<User> findByUserTeam(Team t);
	public List<User> findByTeamId(String tid);
}
