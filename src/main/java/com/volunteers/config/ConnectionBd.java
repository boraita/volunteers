package com.volunteers.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.volunteers.login.LoginEndPoint;


@Configuration
public class ConnectionBd extends ResourceConfig
{
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	
    public ConnectionBd()
    {
        register(EmptyEndPoint.class);
        register(LoginEndPoint.class);
    }
    
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
    	if (this.dbUrl.isEmpty()) {
			this.dbUrl = System.getenv("DATABASE_URL");
		}
        URI dbUri = new URI(this.dbUrl);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        this.dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(this.dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
	
}
