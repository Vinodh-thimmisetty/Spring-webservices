package com.vinodh.webservices.springwebservices.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProjectsEnityId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7462537891349587337L;
	@Column(name = "PROJECT_ID")
	private Integer projectId;
	@Column(name = "EMP_ID")
	private Long employeeId;

}
