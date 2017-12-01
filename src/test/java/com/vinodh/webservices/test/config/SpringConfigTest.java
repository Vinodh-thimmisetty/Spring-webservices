package com.vinodh.webservices.test.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.vinodh.webservices.springwebservices.config.AuthorizationServerConfiguration;
import com.vinodh.webservices.springwebservices.config.DatabaseConfig;
import com.vinodh.webservices.springwebservices.config.HibernateConfig;
import com.vinodh.webservices.springwebservices.config.MethodSecurityConfig;
import com.vinodh.webservices.springwebservices.config.MyBatisConfig;
import com.vinodh.webservices.springwebservices.config.ResourceServerConfiguration;
import com.vinodh.webservices.springwebservices.config.SecurityWebApplicationInitializer;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class, MyBatisConfig.class, HibernateConfig.class,
		ResourceServerConfiguration.class, MethodSecurityConfig.class,
		SecurityWebApplicationInitializer.class }, loader = AnnotationConfigContextLoader.class)
public class SpringConfigTest {

	@Test
	public void testSpringAppContext() {
		Assert.assertTrue(true);
	}
}
