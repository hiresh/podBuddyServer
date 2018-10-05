package org.oracle.globalpay.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.oracle.globalpay.model.User;
import org.oracle.globalpay.model.Query;
import org.oracle.globalpay.model.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {

	@Autowired
	QueryService queryService;
	@Autowired
	UserService userService;
	
	public Date getMaxUpdDate() {
		return queryService.getMaxUpdDate();
	}
	
	public List<UserQuery> getUserQueries(String userName) {
		if(userService.userLatestRequestMap.isEmpty()){
			userService.getAllUsers().forEach(u->{
				if(u!=null && u.getRegisteredName()!=null){

					ArrayList<Query> queriesByAuthor=(ArrayList<Query>) queryService.getQueriesByAuthor(u.getRegisteredName());
					if(queriesByAuthor!=null && !queriesByAuthor.isEmpty()){
						//Date maxDate=queriesByAuthor.stream().map(Query::getLastUpdated).max(Date::compareTo).get();
						Date maxDate=null;
						try {
							maxDate = new SimpleDateFormat("yyyy-MM-dd").parse("0001-01-01");
						} catch (ParseException e) {
							e.printStackTrace();
						}
						for(Query q:queriesByAuthor){
							if(q.getLastUpdated()!=null && q.getLastUpdated().after(maxDate)){
								maxDate=q.getLastUpdated();
								if(maxDate.after(queryService.getGlobalLatestRequestTime())){
									queryService.setGlobalLatestRequestTime(maxDate);
								}
							}
						}
					if(!userName.equals(u.getRegisteredName()))
						userService.userLatestRequestMap.put(u.getRegisteredName(), maxDate);
					}
				
				}
			});
		}
		if(userService.userLatestRequestMap.get(userName)==null || queryService.getGlobalLatestRequestTime().after(userService.userLatestRequestMap.get(userName))){
			
			userService.userLatestRequestMap.put(userName, queryService.getGlobalLatestRequestTime());
		List<UserQuery> userQueries = new ArrayList<>();
		(queryService.getUsers()).forEach(u -> {
			UserQuery userQuery = new UserQuery();
			User user=userService.getUser(u);
			if(user!=null&&user.getRegisteredName()!=null&&!"".equals(user.getRegisteredName())){
			userQuery.setUser(user);
			userQuery.setQueries(queryService.getQueriesByAuthor(u));
			userQueries.add(userQuery);
			}
		});
		return userQueries;
		}
		else{
			return null;
		}
		
	}	
}
