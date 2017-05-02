/**
 * 
 */
package com.example;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author shikha
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

	public SecurityWebApplicationInitializer(){
		super(TheSecurityConfig.class);
	}
}
