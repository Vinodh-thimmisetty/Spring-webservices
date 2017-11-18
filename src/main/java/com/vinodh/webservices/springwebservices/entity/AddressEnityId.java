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
public class AddressEnityId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4416657311832813281L;
	@Column(name = "ADDRESS_ID", nullable = false)
	private Integer addressId;
	@Column(name = "EMP_ID", nullable = false)
	private Integer empId;

}
