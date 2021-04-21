package com.wolken.wolkenapp.resources;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	Logger logger = Logger.getLogger("StudentResource");

	@Autowired
	StudentService studentService;

	@PutMapping("/updateContactByEmail")
	public boolean UpdateContactByEmail(@RequestBody StudentEntity studentEntity) {
		logger.info("Inside student resource , update contact by email");
		return studentService.ValidateAndUpdateContactByEmail(studentEntity.getScontactno(), studentEntity.getSemail());

	}

	@PutMapping("/updateNameByEmail")
	public ResponseEntity<StudentEntity> UpdateNameByEmail(@RequestBody StudentEntity studentEntity) {
		logger.info("inside student resource update name by email");
		StudentEntity studen = studentService.ValidateAndUpdateNameByEmail(studentEntity.getSname(),
				studentEntity.getSemail());
		if (studen != null)
			return new ResponseEntity<StudentEntity>(studen, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<StudentEntity>(studen, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/savestud")
	public ResponseEntity<String> savestudent(@RequestBody StudentEntity studententity) {
		logger.info("inside student resource save student entity");
		String result = studentService.validateAndSavestudent(studententity);
		if (result != null)
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/savedto")
	public ResponseEntity<String> savedto(@RequestBody StudentDTO dto) {
		logger.info("inside student resource save studentDTO");
		String result = studentService.validateAndSaveDto(dto);
		if (result != null)
			return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/bynameoremail")
	public ResponseEntity<StudentEntity> getBynameoremail(@RequestBody StudentEntity studententity) {
		logger.info("inside student resource get by name or email");
		StudentEntity studen = studentService.validateAndgetAllByNameOrEmail(studententity);
		if (studen != null)
			return new ResponseEntity<StudentEntity>(studen, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<StudentEntity>(studen, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/bynameoremailordoborcontact")
	public ResponseEntity<List<StudentEntity>> getAllByNameOrEmailOrDobOrContact(@RequestBody StudentEntity studententity) {
		logger.info("inside student resource get by name or email or dob or contact");
		List<StudentEntity> studen=studentService.validateAndgetAllByNameOrEmailOrDobOrContact(studententity);
        if(studen!=null)
        	return new ResponseEntity<List<StudentEntity>>(studen,HttpStatus.ACCEPTED);
        else
        	return new ResponseEntity<List<StudentEntity>>(studen,HttpStatus.BAD_REQUEST);
	}

}
