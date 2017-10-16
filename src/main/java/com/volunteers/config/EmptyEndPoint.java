package com.volunteers.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/users")
public class EmptyEndPoint {
	
	@GET
    @Produces("application/json")
    public String getAllUsers() {
        
        return "Error 404";
    }


}
