package com.vinodh.webservices.springwebservices.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "VINODH", name = "EMPLOYEE", uniqueConstraints = @UniqueConstraint(columnNames = "EMP_ID"))
@NamedQueries(value = {

		@NamedQuery(name = "employee.findbyId", query = "from EmployeeEntity where employeeId = :employeeId"),
		@NamedQuery(name = "employee.findbyName", query = "from EmployeeEntity where employeeName = :employeeName"),
		@NamedQuery(name = "employee.findAllEmployees", query = "from EmployeeEntity"),
		// @NamedQuery(name = "employee.findAllEmployees", query = "from EmployeeEntity
		// e inner join ParentsEntity p on e.emp_id = p.emp_id inner join ProjectEntity
		// pr on e.emp_id = pr.emp_id inner join AddressEnity a on e.emp_id =
		// a.emp_id"),
		@NamedQuery(name = "employee.isEmployeeExist", query = "from EmployeeEntity e where employeeId = :employeeId"),
		@NamedQuery(name = "employee.deleteEmployeeById", query = "delete EmployeeEntity where employeeId = :employeeId"),
		@NamedQuery(name = "employee.deleteAllEmployees", query = "delete EmployeeEntity")

})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employeeId")
public class EmployeeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1671241405003067008L;
	@Id
	@GeneratedValue(generator = "EMPLOYEE_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "EMPLOYEE_ID_SEQ", schema = "VINODH", sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1)
	@Column(name = "EMP_ID", nullable = false, unique = true, updatable = false, insertable = false)
	private Long employeeId;
	@NotBlank
	@Column(name = "EMP_NAME")
	private String employeeName;
	@Column(name = "EMP_PHONE")
	@NotNull
	private Long employeePhone;
	@Column(name = "EMP_SALARY")
	@NotNull
	private Double employeeSalary;
	@Column(name = "EMP_EMAIL")
	@Email
	private String employeeEmail;
	@Column(name = "EMP_DOB")
	@Temporal(TemporalType.DATE)
	@Past
	private Date employeeDOB;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value="employee",allowSetters=true)
	private ParentsEntity parents;

	/*// @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<ProjectEntity> projects = new HashSet<>(0);

	// @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<AddressEnity> addresses = new HashSet<>(0);*/

}
