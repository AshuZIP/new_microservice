/**
 * 
 */
package com.ashu.organizationservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ashutosh.Ranjan
 *
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
	
	private Long id;
	private String organizationName;
	private String organizationDescription;
	private String organizationCode;
	private LocalDateTime createdDate;
}
