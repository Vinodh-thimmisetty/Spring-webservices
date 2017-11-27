/* Employee Information*/

Insert into VINODH.EMPLOYEE
   (EMP_ID, EMP_NAME, EMP_PHONE, EMP_SALARY, EMP_EMAIL, EMP_DOB)
 Values
   (1, 'Vinodh Kumar', 1234, 50000, 'vinodh@gmail.com',SYSDATE);

Insert into VINODH.EMPLOYEE
   (EMP_ID, EMP_NAME, EMP_PHONE, EMP_SALARY, EMP_EMAIL, EMP_DOB)
 Values
   (2, 'Thimisetty', 123456, 50000, 'thimisetty@gmail.com',SYSDATE);
   
/* Parents Information*/   
   
Insert into VINODH.PARENTS
   (EMP_ID, FATHER_NAME, FATHER_PHONE, MOTHER_NAME, MOTHER_PHONE)
 Values
   (1, 'father', 12345, 'mother',7230); 
   
Insert into VINODH.PARENTS
   (EMP_ID, FATHER_NAME, FATHER_PHONE, MOTHER_NAME, MOTHER_PHONE)
 Values
   (2, 'father', 167890, 'mother',71230); 

   
/* Address Information*/  

Insert into VINODH.ADDRESS
   (EMP_ID, ADDRESS_ID, STREET_NAME, CITY_NAME, STATE_NAME,COUNTRY_NAME, ZIP_CODE)
 Values
   (1, 1, 'Shols', 'Chennai', 'Tamilnadu','India','600019');
   
Insert into VINODH.ADDRESS
   (EMP_ID, ADDRESS_ID, STREET_NAME, CITY_NAME, STATE_NAME,COUNTRY_NAME, ZIP_CODE)
 Values
   (1, 2, 'Kodur', 'Kadapa', 'Andhra Pradesh','India','516101');   
      
Insert into VINODH.ADDRESS
   (EMP_ID, ADDRESS_ID, STREET_NAME, CITY_NAME, STATE_NAME,COUNTRY_NAME, ZIP_CODE)
 Values
   (2, 1, 'Shols', 'Chennai', 'Tamilnadu','India','600019');
   
Insert into VINODH.ADDRESS
   (EMP_ID, ADDRESS_ID, STREET_NAME, CITY_NAME, STATE_NAME,COUNTRY_NAME, ZIP_CODE)
 Values
   (2, 2, 'Kodur', 'Kadapa', 'Andhra Pradesh','India','516101');   
     
/* Projects Information*/  
   
Insert into VINODH.PROJECTS
   (EMP_ID, PROJECT_ID, PROJECT_NAME, CLIENT_NAME, PROJECT_PERIOD,PROJECT_STATUS)
 Values
   (1, 1, 'Webervices', 'Infosys', 6,'Completed');
   
Insert into VINODH.PROJECTS
   (EMP_ID, PROJECT_ID, PROJECT_NAME, CLIENT_NAME, PROJECT_PERIOD,PROJECT_STATUS)
 Values
   (1, 2, 'Spring-mvc', 'Infosys', 2,'Design');   

Insert into VINODH.PROJECTS
   (EMP_ID, PROJECT_ID, PROJECT_NAME, CLIENT_NAME, PROJECT_PERIOD,PROJECT_STATUS)
 Values
   (2, 1, 'Webervices', 'Infosys', 6,'Completed');
   
Insert into VINODH.PROJECTS
   (EMP_ID, PROJECT_ID, PROJECT_NAME, CLIENT_NAME, PROJECT_PERIOD,PROJECT_STATUS)
 Values
   (2, 2, 'Spring-mvc', 'Infosys', 2,'Design'); 
   
    /* TECHNOLOGIES Information*/  
   
Insert into VINODH.TECHNOLOGIES
   (TECH_NAME, TECH_VERSION, TECH_CATEGORY)
 Values
   ('Spring', '5', 'Web');
   
Insert into VINODH.TECHNOLOGIES
   (TECH_NAME, TECH_VERSION, TECH_CATEGORY)
 Values
   ('Mybatis', '3', 'Database');
   
Insert into VINODH.TECHNOLOGIES
   (TECH_NAME, TECH_VERSION, TECH_CATEGORY)
 Values
   ('Java', '1.8', 'Programming'); 
      
   
