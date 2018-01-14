package com.baeldung.tutorial.beaninjection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import com.baeldung.tutorial.beaninjection.beans.DemoGraphic;
import com.baeldung.tutorial.beaninjection.beans.UserCredentials;
import com.baeldung.tutorial.beaninjection.beans.UserProfile;

@Configuration
@PropertySources({ @PropertySource("classpath:userProfile.properties") })
@ComponentScan(basePackages = { "com.baeldung.tutorial.beaninjection.*" })
@Profile(value="beansconfig")
public class BeanInjectionConfig {
	
	@Autowired
	private Environment environment;

	@Bean
	DemoGraphic demoGraphic() {
		String city = environment.getProperty("city");
		String state = environment.getProperty("state");
		String zip = environment.getProperty("pin");
		return new DemoGraphic(city, state, zip);
	}
	@Bean
	UserProfile userProfile() {
		return new UserProfile(credentials(),demoGraphic());
	}

	@Bean
	UserCredentials credentials() {
		String userName = environment.getProperty("userName");
		UserCredentials userCred = new UserCredentials();
		userCred.setUserName(userName);
		return userCred;
	}
}
