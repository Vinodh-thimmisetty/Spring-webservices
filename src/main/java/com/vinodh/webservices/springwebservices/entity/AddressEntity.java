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
@Table(schema = "VINODH", name = "ADDRESS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employeeId") 
public class AddressEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9137154396983589859L;
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "addressId", column = @Column(name = "ADDRESS_ID", nullable = false)),
			@AttributeOverride(name = "employeeId", column = @Column(name = "EMP_ID", nullable = false)) })
	private AddressEntityId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", nullable = false, insertable = false, updatable = false)
	private EmployeeEntity employee;
	@Column(name = "STREET_NAME", length = 50)
	private String streetName;
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	@Column(name = "COUNTRY_NAME", length = 50)
	private String countryName;
	@Column(name = "ZIP_CODE", length = 50)
	private String zipCode;
}
