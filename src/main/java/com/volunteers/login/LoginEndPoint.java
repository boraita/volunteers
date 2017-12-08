package com.volunteers.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.volunteers.models.UserModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping("/api")
	public class LoginEndPoint {
	    
	    @Autowired
	    private DataSource dataSource;
	    
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public UserModel loginVolunteer(@RequestBody Map<String, Object> userRequest) throws Exception {
	    	
	    	if (userRequest.get("nick") == null || userRequest.get("password") == null) {
	            throw new Exception("Please fill in username and password");
	        }
	    	UserModel user;
    		Connection connection = dataSource.getConnection();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE (nick = '"+userRequest.get("nick").toString().toLowerCase()+"' OR email = '"+userRequest.get("nick").toString().toLowerCase()+"') "
    				+ "AND password = '"+userRequest.get("password")+"';");
	      if(rs.next()) { 
	    	  user = new UserModel(rs);
	    	  String jwtToken = Jwts.builder().setSubject(user.getEmail()).claim("roles", "user").setIssuedAt(new Date())
	  				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	        
	      }
	      else {
	    	  user = null;
	      }
	        return user;
	    }
	    
	}
