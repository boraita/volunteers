package com.volunteers.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.volunteers.models.UserModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Path("/api")
	public class LoginEndPoint {
	    
	    @Autowired
	    private DataSource dataSource;
	    
	    @POST
	    @Path("login")
	    @Produces("application/json")
	    public UserModel loginVolunteer(
	    		@FormParam("user") String userString,
	    		@FormParam("pass") String pass) throws Exception {
	    	String jwtToken = "";
	    	if (userString == null || userString == null) {
	            throw new Exception("Please fill in username and password");
	        }
	    	UserModel user;
    		Connection connection = dataSource.getConnection();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE (nick = '"+userString.toLowerCase()+"' OR email = '"+userString.toLowerCase()+"') "
    				+ "AND password = '"+pass+"';");
	      if(rs.next()) { 
	    	  user = new UserModel(rs);
    	  		jwtToken = Jwts.builder().setSubject(user.getEmail()).claim("roles", "user").setIssuedAt(new Date())
	  				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	        
	      }
	      else {
	    	  user = null;
	      }
	        return user;
	    }
	    
	}
