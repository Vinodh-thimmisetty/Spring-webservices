SET DATABASE SQL SYNTAX ORA TRUE;
CREATE SCHEMA VINODH
	 CREATE TABLE EMPLOYEE (
 		 EMP_ID INT,
   		 EMP_NAME VARCHAR2(50) NOT NULL,
   		 EMP_PHONE INT,
   		 EMP_SALARY INT,
   		 EMP_EMAIL VARCHAR2(50) NOT NULL,
   		 EMP_DOB DATE,
   		 CONSTRAINT PK_EMPLOYEE PRIMARY KEY (EMP_ID)
    )
    
    CREATE TABLE PARENTS (
		  EMP_ID      NUMBER,
		  FATHER_NAME    VARCHAR2(50 BYTE),
		  FATHER_PHONE NUMBER,
		  MOTHER_NAME  VARCHAR2(50 BYTE),
		  MOTHER_PHONE NUMBER,
		  CONSTRAINT PK_PARENTS PRIMARY KEY (EMP_ID),
		  CONSTRAINT FK_PARENTS FOREIGN KEY(EMP_ID) REFERENCES EMPLOYEE(EMP_ID)
	)
	
   	CREATE TABLE ADDRESS (
  		EMP_ID        NUMBER,
  		ADDRESS_ID    NUMBER,
		STREET_NAME   VARCHAR2(50 BYTE),
  		CITY_NAME     VARCHAR2(50 BYTE),
  		STATE_NAME    VARCHAR2(50 BYTE),
  		COUNTRY_NAME  VARCHAR2(50 BYTE),
  		ZIP_CODE      VARCHAR2(50 BYTE),
  		CONSTRAINT PK_ADDRESS PRIMARY KEY  (ADDRESS_ID, EMP_ID),
  		CONSTRAINT FK_ADDRESS FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE (EMP_ID)
	)

	CREATE TABLE PROJECTS (
		  PROJECT_ID      NUMBER,
		  EMP_ID          NUMBER,
		  PROJECT_NAME    VARCHAR2(50 BYTE),
		  CLIENT_NAME     VARCHAR2(50 BYTE),
		  PROJECT_PERIOD  NUMBER,
		  PROJECT_STATUS  VARCHAR2(20 BYTE),
		  CONSTRAINT PK_PROJECTS PRIMARY KEY  (PROJECT_ID, EMP_ID),
		  CONSTRAINT FK_PROJECTS FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE (EMP_ID)
	)

	CREATE SEQUENCE EMPLOYEE_ID_SEQ AS INTEGER START WITH 1 INCREMENT BY 1
	CREATE SEQUENCE ADDRESS_ID_SEQ  AS INTEGER START WITH 1 INCREMENT BY 1 
	CREATE SEQUENCE PROJECT_ID_SEQ  AS INTEGER START WITH 1 INCREMENT BY 1
	
GRANT SELECT,UPDATE,INSERT,DELETE ON EMPLOYEE TO PUBLIC
GRANT SELECT,UPDATE,INSERT,DELETE ON PARENTS  TO PUBLIC
GRANT SELECT,UPDATE,INSERT,DELETE ON ADDRESS  TO PUBLIC
GRANT SELECT,UPDATE,INSERT,DELETE ON PROJECTS TO PUBLIC;    