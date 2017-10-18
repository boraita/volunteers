package com.volunteers.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.volunteers.login.models.Volunteer;

@Path("/login")
	public class EndPoint {
	    
	    @Autowired
	    private DataSource dataSource;
	    

	    @GET
	    @Produces("application/json")
	    public Volunteer loginVolunteer() {
	    	Volunteer user = null;
	    	try (Connection connection = dataSource.getConnection()) {
	    		Statement stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery("SELECT * FROM volunteer;");
	      
	        user = new Volunteer(rs);
//	        ArrayList<String> output = new ArrayList<String>();
//	        while (rs.next()) {
//	          output.add("Read from DB: " + rs.getString("name"));
//	        }
	        return user;
	    	}catch (Exception e) {
				return user;
			}
	    }
	}
