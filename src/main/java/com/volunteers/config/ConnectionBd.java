package com.volunteers.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public Connection dataSource() throws URISyntaxException, SQLException {
    	System.out.println("primera url = " + this.dbUrl);
    	System.out.println(System.getenv("DATABASE_URL"));
    	if (this.dbUrl.isEmpty()) {
			this.dbUrl = System.getenv("DATABASE_URL");
		}
        URI dbUri = new URI(this.dbUrl);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        this.dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        
        return DriverManager.getConnection(dbUrl, username, password);
    }
	
}
