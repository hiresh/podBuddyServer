package org.oracle.globalpay.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Team implements Serializable{

	private static final long serialVersionUID = 1L;
	private String _id;
	private String teamName;
	private String teamDescription;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamDescription() {
		return teamDescription;
	}
	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object obj) {
		Team t = (Team)obj;
		if(this._id.equals(t.get_id())){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Team: id: "+this._id+" name: "+this.teamName;
	}
	
	
}
