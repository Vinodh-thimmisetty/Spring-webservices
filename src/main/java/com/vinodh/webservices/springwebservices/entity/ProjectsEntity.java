package com.vinodh.webservices.springwebservices.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "VINODH", name = "PROJECTS") 
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="employeeId")
public class ProjectsEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5915474562160930218L;
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "projectId", column = @Column(name = "PROJECT_ID", nullable = false)),
			@AttributeOverride(name = "employeeId", column = @Column(name = "EMP_ID", nullable = false)) })
	private ProjectsEnityId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", nullable = false, insertable = false, updatable = false)
	private EmployeeEntity employee;
	@Column(name = "PROJECT_NAME", length = 50)
	private String projectName;
	@Column(name = "CLIENT_NAME", length = 50)
	private String clientName;
	@Column(name = "PROJECT_PERIOD")
	private Integer projectPeriod;
	@Column(name = "PROJECT_STATUS", length = 20)
	private String projectStatus;

}