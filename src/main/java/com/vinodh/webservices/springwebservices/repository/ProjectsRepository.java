package com.vinodh.webservices.springwebservices.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.vinodh.webservices.springwebservices.domain.Filters;
import com.vinodh.webservices.springwebservices.entity.ProjectsEntity;

/**
 * 
 * Mybatis CRUD operations using XML configurations
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Repository
public interface ProjectsRepository {

	/**
	 * List of available Projects irrespective of Employee Information.
	 * 
	 * @param schema
	 *            To identify the Regional Schema information
	 * @return List<ProjectsEntity>
	 */
	List<ProjectsEntity> getAllProjects(@Param("schema") String schema);

	/**
	 * List Count of Project based on filtered Params
	 * 
	 * 
	 * @param schema
	 * @return
	 */
	int projectsCount(@Param("schema") String schema, @Param("filters") Filters filters);

}
