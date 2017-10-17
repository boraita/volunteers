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
	public class LoginEndPoint {
	    
	    @Autowired
	    private DataSource dataSource;
	    

	    @GET
	    @Produces("application/json")
	    public Volunteer loginVolunteer() {
	    	Volunteer user = null;
	    	try (Connection connection = dataSource.getConnection()) {
	    		Statement stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery("SELECT * FROM volunteer;");
	      if(rs.next()) { 
	        user = new Volunteer(rs);
	      }
	        return user;
	    	}catch (Exception e) {
				return user;
			}
	    }
	}