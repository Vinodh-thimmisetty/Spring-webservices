package com.vinodh.webservices.springwebservices.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "VINODH", name = "PROJECTS")
public class ProjectsEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5915474562160930218L;
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "projectId", column = @Column(name = "PROJECT_ID", nullable = false)),
			@AttributeOverride(name = "employeeId", column = @Column(name = "EMP_ID", nullable = false)) })
	@JsonIgnore
	private ProjectsEnityId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private EmployeeEntity employee;
	@Column(name = "PROJECT_NAME", length = 50)
	private String projectName;
	@Column(name = "CLIENT_NAME", length = 50)
	private String clientName;
	@Column(name = "PROJECT_PERIOD")
	private Integer projectPeriod;
	@Column(name = "PROJECT_STATUS", length = 20)
	private String projectStatus;

	//@OneToMany(fetch=FetchType.EAGER,mappedBy = "employee", cascade = CascadeType.ALL)
	//@Fetch(FetchMode.SELECT)
	@Transient
	private List<TechnologyEntity> technologyEntities;

}
