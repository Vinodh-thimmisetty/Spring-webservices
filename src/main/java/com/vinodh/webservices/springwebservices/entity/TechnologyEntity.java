package com.vinodh.webservices.springwebservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "VINODH", name = "TECHNOLOGIES")
public class TechnologyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1382711887841290627L;
	@Id
	@Column(name = "TECH_NAME")
	private String techName;
	@Column(name = "TECH_VERSION")
	private String techCategory;
	@Column(name = "TECH_CATEGORY")
	private String techVersion;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private ProjectsEntity projects;
*/
}
