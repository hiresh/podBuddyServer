package org.oracle.globalpay.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Query implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String queryName;
	private String description;
	private String queryText;
	private String author;
	private Date lastUpdated;
	private String _id;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQueryText() {
		return queryText;
	}
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	
	
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	@Override
	public boolean equals(Object q){
		Query query=(Query)q;
		if(query._id.equals(this._id))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode(){
		
		int hash = 7;
		for (int i = 0; i < this._id.length(); i++) {
		    hash = hash*31 + this._id.charAt(i);
		}
		
		return hash;
	}
	
	@Override
	public String toString() {
		return "Query [queryName=" + queryName + ", description=" + description + ", queryText="
				+ queryText + ", author=" + author + ", lastUpdated=" + lastUpdated + "]";
	}
}
