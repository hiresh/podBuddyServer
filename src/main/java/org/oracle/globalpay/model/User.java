package org.oracle.globalpay.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String registeredName;
	
	private Team userTeam;
	
	private String teamId;
	
	private String hashedPassword;
	
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public Team getUserTeam() {
		return userTeam;
	}
	public void setUserTeam(Team userTeam) {
		this.userTeam = userTeam;
	}
	private Date lastRequest;
	
	public String getRegisteredName() {
		return registeredName;
	}
	public void setRegisteredName(String registeredName) {
		this.registeredName = registeredName;
	}
	public Date getLastRequest() {
		return lastRequest;
	}
	public void setLastRequest(Date lastRequest) {
		this.lastRequest = lastRequest;
	}
	
	@Override
	public String toString() {
		return "User [registeredName=" + registeredName + ", lastRequest=" + lastRequest + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastRequest == null) ? 0 : lastRequest.hashCode());
		result = prime * result + ((registeredName == null) ? 0 : registeredName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		
		if (registeredName == null) {
			if (other.registeredName != null)
				return false;
		} else if (!registeredName.equals(other.registeredName))
			return false;
		else if(!hashedPassword.equals(other.hashedPassword))
			return false;
		return true;
	}
	
	
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
}
