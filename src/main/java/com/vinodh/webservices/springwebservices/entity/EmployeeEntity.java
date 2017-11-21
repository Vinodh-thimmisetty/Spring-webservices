package com.vinodh.webservices.springwebservices.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "parents", "projects", "addresses" })
@Entity
@Table(schema = "VINODH", name = "EMPLOYEE")
@NamedQueries(value = {

		@NamedQuery(name = "employee.findbyId.noJPAMappings", query = "from EmployeeEntity where employeeId = :employeeId"),
		@NamedQuery(name = "employee.findbyId", query = "select e from EmployeeEntity e left outer join e.parents p on e.employeeId = p.employeeId left outer join e.projects pr on e.employeeId = pr.id.employeeId left outer join e.addresses a on e.employeeId =a.id.employeeId where e.employeeId = :employeeId"),
		@NamedQuery(name = "employee.findbyName", query = "from EmployeeEntity where employeeName = :employeeName"),
		@NamedQuery(name = "employee.findAllEmployees.noJPAMappings", query = "from EmployeeEntity"),
		@NamedQuery(name = "employee.findAllEmployees", query = "select e from EmployeeEntity e left outer join e.parents p on e.employeeId = p.employeeId left outer join e.projects pr on e.employeeId = pr.id.employeeId left outer join e.addresses a on e.employeeId =a.id.employeeId"),
		@NamedQuery(name = "employee.isEmployeeExist", query = "from EmployeeEntity e where employeeId = :employeeId"),
		@NamedQuery(name = "employee.deleteEmployeeById", query = "delete EmployeeEntity where employeeId = :employeeId"),
		@NamedQuery(name = "employee.deleteAllEmployees", query = "delete EmployeeEntity")

})
public class EmployeeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1671241405003067008L;
	@Id
	@GeneratedValue(generator = "EMPLOYEE_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "EMPLOYEE_ID_SEQ", schema = "CUSTOMER_RETURNS", sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1)
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

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	// @JsonIgnoreProperties(value="employee",allowSetters=true)
	private ParentsEntity parents;

	// @JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Set<ProjectsEntity> projects = new HashSet<>(0);

	// @JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Set<AddressEntity> addresses = new HashSet<>(0);

}
