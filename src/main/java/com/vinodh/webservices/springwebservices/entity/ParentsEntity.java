package com.vinodh.webservices.springwebservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(schema = "VINODH", name = "PARENTS")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="employeeId")
public class ParentsEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 222056424508901935L;
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "EMP_ID", unique = true, nullable = false, precision = 22, scale = 0)
	private Long employeeId;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn 
	@JsonIgnoreProperties(value="parents",allowSetters=true)
	private EmployeeEntity employee;
	@Column(name = "FATHER_NAME", length = 50)
	private String fatherName;
	@Column(name = "FATHER_PHONE", precision = 22, scale = 0)
	private Integer fatherPhone;
	@Column(name = "MOTHER_NAME", precision = 22, scale = 0)
	private String motherName;
	@Column(name = "MOTHER_PHONE", precision = 22, scale = 0)
	private Integer motherPhone;
}
