package com.volunteers.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmptyEndPoint {
	
    public String error404() {
        return "404";
    }


}
