package com.vinodh.webservices.springwebservices.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * 
 * This is where the original data is stored(Server hosting the protected
 * resource). If client has access_token, he/she can request any data from here.
 * 
 * http://www.bubblecode.net/en/2016/01/22/understanding-oauth2/
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http
			.anonymous().disable() // don't allow anonymous logins
			.requestMatchers().antMatchers("/user/**") // All resources will be inside **/user/** folders
			.and()
			.authorizeRequests()
				.antMatchers("/user/**").access("hasRole('ADMIN')") // Must have Admin role
			.and()
			.exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
		//@formatter:on
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("sample_rest_api").stateless(false);
	}

}
