package com.wolken.wolkenapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.dto.StudentDTO;
import com.wolken.wolkenapp.entity.StudentEntity;
import com.wolken.wolkenapp.service.StudentService;

@RequestMapping("/")
@RestController
@Controller
  public class StudentResource {
  
  @Autowired StudentService studentService;
  
  @PutMapping("/updateContactByEmail") 
  public boolean UpdateContactByEmail(@RequestBody StudentEntity studentEntity) {
  
  return studentService.ValidateAndUpdateContactByEmail(studentEntity.getScontactno(),studentEntity.getSemail());
  
  }
  
  @PutMapping("/updateNameByEmail") 
  public StudentEntity UpdateNameByEmail(@RequestBody StudentEntity studentEntity) {
  
  return studentService.ValidateAndUpdateNameByEmail(studentEntity.getSname(),studentEntity.getSemail());

  }
  @PostMapping("/savestud")
  public String savestudent(@RequestBody StudentEntity studententity) { 
	  return studentService.validateAndSavestudent(studententity);
  }
  
  @PostMapping("/savedto")
  public String savedto(@RequestBody StudentDTO dto) {
  return studentService.validateAndSaveDto(dto);
	  
  }
  
  @GetMapping("/bynameoremail")
  public StudentEntity getBynameoremail(@RequestBody StudentEntity studententity) {
	return studentService.validateAndgetAllByNameOrEmail(studententity);
	  
  }
  
  @GetMapping("/bynameoremail")
  public List<StudentEntity> getAllByNameOrEmailOrDobOrContac(@RequestBody StudentEntity studententity) {
	return studentService.validateAndgetAllByNameOrEmailOrDobOrContact(studententity);
	  
  }
 
  }
  

 