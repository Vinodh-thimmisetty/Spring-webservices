package com.vinodh.webservices.springwebservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
public class Oauth2SSecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static final String ADMIN = "ADMIN";

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	/*
	 * Resource Owners who are allowed to request for access token i.e., send
	 * request to authentication servers
	 */
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off 

		/*
		UserBuilder users = User.withDefaultPasswordEncoder();
			UserDetails user =  users.username("Pavan").password("password").roles("USER").build();
			UserDetails admin = users.username("Vinodh").password("password").roles("ADMIN").build();*/
			
		auth
			.inMemoryAuthentication()
				.withUser("Vinodh").password("abcd1234").roles("ADMIN")
				.and()
				.withUser("user").password("abcd1234").roles("USER")
				/*.and()
				.withUser(user).withUser(admin)*/;
		//@formatter:on
	}
	/*
	 * @Autowired public void configureGlobalSecurity(AuthenticationManagerBuilder
	 * auth) throws Exception { // Memory Database
	 * auth.inMemoryAuthentication().withUser("bill").password("abc123").roles(
	 * "USER");
	 * auth.inMemoryAuthentication().withUser("admin").password("root123").roles(
	 * ADMIN);
	 * auth.inMemoryAuthentication().withUser("dba").password("root123").roles(
	 * ADMIN, "DBA");
	 * auth.inMemoryAuthentication().withUser("Vinodh").password("abcd1234").roles(
	 * "SUPER_ADMIN", "APPLICATION_ADMIN", "APPLICATION_USER", ADMIN, "USER",
	 * "DBA");
	 * 
	 * // Custom User Database }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/oauth/token").permitAll();
	}

	@Bean
	@Autowired
	public TokenStoreUserApprovalHandler tokenStoreUserApprovalHandler() {
		TokenStoreUserApprovalHandler tokenStoreUserApprovalHandler = new TokenStoreUserApprovalHandler();
		tokenStoreUserApprovalHandler.setTokenStore(tokenStore());
		tokenStoreUserApprovalHandler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
		tokenStoreUserApprovalHandler.setClientDetailsService(clientDetailsService);
		return tokenStoreUserApprovalHandler;
	}

	@Bean
	@Autowired
	public ApprovalStore approvalStore() throws Exception {
		TokenApprovalStore store = new TokenApprovalStore();
		store.setTokenStore(tokenStore());
		return store;
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	/**
	 * 
	 * // PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
