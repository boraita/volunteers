package com.volunteers.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class EmptyEndPoint {
	
	@GET
    @Produces("application/json")
    public String error404() {
        return "404";
    }


}
