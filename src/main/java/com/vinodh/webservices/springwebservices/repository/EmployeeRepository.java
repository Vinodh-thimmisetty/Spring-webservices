package com.vinodh.webservices.springwebservices.repository;

import java.time.LocalDate;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Result;

import org.apache.ibatis.annotations.Results;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.SelectKey;

import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Repository;

import com.vinodh.webservices.springwebservices.domain.Employee;

@Repository

public interface EmployeeRepository {

	/**
	 * 
	 * 
	 * 
	 * With annotations, it took 3294ms in POSTMAN while in xml it took >3500ms
	 * 
	 * 
	 * 
	 * @param employeeId
	 * 
	 * @return
	 * 
	 */

	@Results(value = {

			@Result(column = "EMP_ID", property = "employeeId", javaType = Long.class),

			@Result(column = "EMP_NAME", property = "employeeName", javaType = String.class),

			@Result(column = "EMP_PHONE", property = "employeePhone", javaType = Long.class),

			@Result(column = "EMP_SALARY", property = "employeeSalary", javaType = Double.class),

			@Result(column = "EMP_EMAIL", property = "employeeEmail", javaType = String.class),

			@Result(column = "EMP_DOB", property = "employeeDOB", javaType = LocalDate.class)

	})

	@Select("SELECT EMP_ID,EMP_NAME,EMP_PHONE,EMP_SALARY,EMP_EMAIL,EMP_DOB FROM VINODH.EMPLOYEE WHERE EMP_ID = #{employeeId}")

	Employee findById(@Param("employeeId") long employeeId);

	@Select("SELECT * FROM VINODH.EMPLOYEE WHERE EMP_NAME = #{employeeName}")

	Employee findByName(@Param("employeeName") String employeeName);

	/**
	 * 
	 * 
	 * 
	 * 3570ms with annotations 3900ms with XMLs
	 * 
	 * 
	 * 
	 * @return
	 * 
	 */

	@Results(value = {

			@Result(column = "EMP_ID", property = "employeeId", javaType = Long.class),

			@Result(column = "EMP_NAME", property = "employeeName", javaType = String.class),

			@Result(column = "EMP_PHONE", property = "employeePhone", javaType = Long.class),

			@Result(column = "EMP_SALARY", property = "employeeSalary", javaType = Double.class),

			@Result(column = "EMP_EMAIL", property = "employeeEmail", javaType = String.class),

			@Result(column = "EMP_DOB", property = "employeeDOB", javaType = LocalDate.class)

	})

	@Select("SELECT EMP_ID,EMP_NAME,EMP_PHONE,EMP_SALARY,EMP_EMAIL,EMP_DOB FROM VINODH.EMPLOYEE")

	List<Employee> findAllEmployees();

	@Insert({

		//@formatter:off

			"INSERT INTO VINODH.EMPLOYEE "

			+ " (EMP_ID,EMP_NAME,EMP_PHONE,EMP_SALARY,EMP_EMAIL,EMP_DOB)"

			+ "	VALUES"

			+ "	(#{employee.employeeId},#{employee.employeeName},#{employee.employeePhone},#{employee.employeeSalary},#{employee.employeeEmail},#{employee.employeeDOB})"

		//@formatter:on

	})

	@SelectKey(statement = "select VINODH.AUDIT_LOG_ID_SEQ.nextval from dual", before = true, keyProperty = "employee.employeeId", resultType = Long.class)

	int saveEmployee(@Param("employee") Employee employee);

	int saveMultipleEmployees(@Param("employees") List<Employee> employees);

	/**
	 * 
	 * 
	 * 
	 * 3271ms for annotations 3500ms for XMLs
	 * 
	 * 
	 * 
	 * @param employee
	 * 
	 * @return
	 * 
	 */

	@Update({

		//@formatter:off

			"UPDATE VINODH.EMPLOYEE"

			+ " SET"

			+ " EMP_NAME = #{employee.employeeName},"

			+ " EMP_SALARY = #{employee.employeeSalary},"

			+ " EMP_PHONE =#{employee.employeePhone}"

			+ " WHERE EMP_ID = #{employee.employeeId}" 

		//@formatter:on	

	})

	int updateEmployee(@Param("employee") Employee employee);

	@Update({

		//@formatter:off

		 //"<script>"

		//	+

		 "MERGE INTO VINODH.EMPLOYEE SOURCE"

				    + " USING (SELECT 1 FROM DUAL) TARGET"

					+ " ON (SOURCE.EMP_ID = #{employee.employeeId})"

				    + " WHEN MATCHED THEN "

					+ " UPDATE "

				    + " SET"

				 //   + " EMP_ID = #{employee.employeeId},"

				//	+ " <if test='#{employee.employeeName} != null'> "

				//	+ " <![CDATA[ "

					+ " EMP_NAME = #{employee.employeeName},"

				//	+ " ]]> "

				//	+ " </if>" 

				//	+ " <if test='#{employee.employeeSalary} != null'> "

				//	+ " <![CDATA[ "

					+ " EMP_SALARY = #{employee.employeeSalary},"

				//	+ " ]]> "

				//	+ " </if>" 

				//	+ " <if test='#{employee.employeePhone} != null'> "

				//	+ " <![CDATA[ "

					+ " EMP_PHONE =#{employee.employeePhone},"

				//	+ " ]]> "

				//	+ " </if>" 

				//	+ " <if test='#{employee.employeeEmail} != null'> "

				//	+ " <![CDATA[ "

					+ " EMP_EMAIL =#{employee.employeeEmail},"

				//	+ " ]]> "

				//	+ " </if>" 

				//	+ " <if test='#{employee.employeeDOB} != null'> "

				//	+ " <![CDATA[ "

					+ " EMP_DOB =#{employee.employeeDOB}"

				//	+ " ]]> "

				//	+ " </if>"  

					+ "	WHEN NOT MATCHED THEN"

					+ " INSERT "

					+ " (EMP_ID,EMP_NAME,EMP_PHONE,EMP_SALARY,EMP_EMAIL,EMP_DOB)"

					+ "	VALUES"

					+ "	(#{employee.employeeId},#{employee.employeeName},#{employee.employeePhone},#{employee.employeeSalary},#{employee.employeeEmail},#{employee.employeeDOB})"

	//	+ "</script>"

	 //@formatter:on	

	})

	int mergeEmployee(@Param("employee") Employee employee);

	@Delete({

			"DELETE FROM VINODH.EMPLOYEE WHERE EMP_ID = #{employeeId}"

	})

	int deleteEmployeeById(@Param("employeeId") long employeeId);

	@Delete({

			"DELETE FROM VINODH.EMPLOYEE"

	})

	int deleteAllEmployees();

	@Select("SELECT COUNT(1) FROM VINODH.EMPLOYEE WHERE EMP_ID = #{employeeId}")

	int isEmployeeExist(@Param("employeeId") long employeeId);

}
