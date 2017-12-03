package com.vinodh.webservices.springwebservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuhtServerUsingJDBCToken extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DatabaseConfig datasourceConfig;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		//@formatter:off
		security
				.accessDeniedHandler(new OAuth2AccessDeniedHandler())
				.realm("sample_realm/client")
				.passwordEncoder(passwordEncoder())	
				.checkTokenAccess("isAuthenticated()")
				.tokenKeyAccess("permitAll()");
		//@formatter:on
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//@formatter:off	
		clients
			   .jdbc(datasourceConfig.dataSource())
			   .withClient("sample-client") // client ID, this is required while requesting /oauth/authorize endpoint
					.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
					.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
					.scopes("read", "write", "trust")
					.secret("secret") // password
			   .and()
			   .withClient("vinodh-clent")
					.authorizedGrantTypes("password")
					.authorities("ROLE_CLIENT")
					.scopes("read")
					.secret("vinodh")
			   .accessTokenValiditySeconds(120)
			   .refreshTokenValiditySeconds(600);
		//@formatter:on
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//@formatter:off
		endpoints
				.allowedTokenEndpointRequestMethods(HttpMethod.POST)
				.authenticationManager(authenticationManager)
				.tokenStore(tokenStore());
		//@formatter:on
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
		accessDeniedHandler.setErrorPage("/accessDenied");
		return accessDeniedHandler;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(datasourceConfig.dataSource());
	}
}
