package com.volunteers.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConnectionBd extends ResourceConfig
{
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	
//    public JerseyServer()
//    {
//        register(Service.class);
//    }
    
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
    	if (dbUrl == null) {
			return null;
		}
        URI dbUri = new URI(dbUrl);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
	
}
