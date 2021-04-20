package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.StudentDTO;
import com.wolken.wolkenapp.entity.StudentEntity;

public interface StudentService {

	
	  public boolean ValidateAndUpdateContactByEmail(long scontactno, String semail);
	  
	  public StudentEntity ValidateAndUpdateNameByEmail(String sname,String semail);
	 
	  public String validateAndSavestudent(StudentEntity studententity);
	  
	  public String validateAndSaveDto(StudentDTO dto);
	  
	  public StudentEntity validateAndgetAllByNameOrEmail(StudentEntity studententity);

	public List<StudentEntity> validateAndgetAllByNameOrEmailOrDobOrContact(StudentEntity studententity);
	
   

}
