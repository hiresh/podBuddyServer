package org.oracle.globalpay.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.oracle.globalpay.model.Team;
import org.oracle.globalpay.model.User;
import org.oracle.globalpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	HashSet<User> users = new HashSet<>();
	HashMap<String,Date> userLatestRequestMap=new HashMap<>();
	@Value("${podbuddy.users.file}")
	String usersFile;
	@Autowired
	UtilityService utilityService;
	
	@Autowired
	UserRepository userMongoRepo;
	
	public void setUsers(HashSet<User> users) {
		this.users = users;
		
		
	}
	
	public boolean addUser(User user) {
		if(users.add(user)){
			userMongoRepo.save(user);
			//saveToFile();
			return true;
		}
		return false;
	}
	
	public void removeUser(User user) {
		users.remove(user);
		saveToFile();
	}
	
	public User getUser(String registeredName) {
		return users.stream().filter(s -> s.getRegisteredName().equals(registeredName))
				.findAny().orElse(null);
	}
	
	public void updateUser(String registeredName, User user) {
		users.remove(getUser(registeredName));
		users.add(user);
		saveToFile();
	}
	
	public HashSet<User> getAllUsers() {
		
		return new HashSet<User>(userMongoRepo.findAll());
		
		//return users;
	}
	
	public HashSet<User> getUsersByTeam(Team t){
		return new HashSet<User>(userMongoRepo.findByUserTeam(t));
	}
	
	public HashSet<User> getUsersByTeamId(String tid){
		return new HashSet<User>(userMongoRepo.findByTeamId(tid));
	}
	
	public void saveToFile() {
		IOService.saveToFile(users, usersFile);
	} 

	@PostConstruct
	public void loadFromFile() {
		//IOService.loadFromFile((new User()), usersFile, this);
		setUsers(getAllUsers());
	}

	public boolean verifyPassword(String name, String hashedPassword) {
		// TODO Auto-generated method stub
		User usr = getUser(name);
		if (usr == null) {
			return false;
		}
		return usr.getHashedPassword().equals(hashedPassword);
	}

	
}
