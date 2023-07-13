/**
 * 
 */
package com.ashu.employeeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ashutosh.Ranjan
 *
 */

@RestController
@RefreshScope
public class MessageController {
	
	@Value("${spring.boot.message}")
	private String message;
	
	@GetMapping("/api/employee/getmessage")
	public String returnMessage() {
		return message;
	}
}
