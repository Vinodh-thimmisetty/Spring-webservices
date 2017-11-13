package com.vinodh.webservices.springwebservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 
 * Authorization Server = AuthorizationEndpoint + TokenEndpoint
 * 
 * AuthorizationEndpoint:: /oauth/authorize ==> used to authenticate a resource
 * owner(may be browser, an oauth2 client) and ask the resource owner to grant
 * the requested scope
 * 
 * TokenEndpoint:: /oauth/token ==> For clients to acquire access_token
 * 
 * Verify client Credentials and provide access_token(limited amount of time) or
 * refresh_token(re generate the new access_token(after expires)).
 * 
 * Token store is used to store the tokens(like in-memory database, we have
 * in-memory token store)
 * 
 * It will contain All clients informations like GRANTS, scopes etc.
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private UserApprovalHandler userApprovalHandler;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//@formatter:off
		endpoints
			.tokenStore(tokenStore)
			.userApprovalHandler(userApprovalHandler)
			.authenticationManager(authenticationManager) ;
		//@formatter:on
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.realm("sample_realm/client");
	}

	/**
	 * 
	 * Its like memory database to go and check the client information
	 * 
	 * 
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//@formatter:off
		clients
			.inMemory()
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

}
