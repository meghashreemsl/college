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


import com.wolken.wolkenapp.entity.CollegeEntity;
import com.wolken.wolkenapp.service.CollegeService;
@RequestMapping("/")
@RestController
@Controller
public class CollegeResource {
	
	Logger logger = Logger.getLogger("CollegeResource");
	@Autowired
	CollegeService collegeService;
	
	@GetMapping("/getAllce")
	public ResponseEntity<List<CollegeEntity>> getAll(@RequestBody CollegeEntity collegeentity){
		logger.info("get all by collegeentity ");
	
		List<CollegeEntity> colent =collegeService.validateAndgetAll();
		if(colent!=null)
			return new ResponseEntity<List<CollegeEntity>>(colent,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<List<CollegeEntity>>(colent,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAllByCityname")
	public ResponseEntity<List<CollegeEntity>> getAllByCityName(@RequestBody CollegeEntity collegeentity){
		logger.info("get all by cityname");
		
		List<CollegeEntity> colent = collegeService.validateAndgetAllByCityName(collegeentity.getCityname());
		if(colent!=null)
			return new ResponseEntity<List<CollegeEntity>>(colent,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<List<CollegeEntity>>(colent,HttpStatus.BAD_REQUEST);
			
	}

	 
	@PostMapping("/savecollege")
	public ResponseEntity<String> save(@RequestBody CollegeEntity collegeentity) {
		logger.info("save college :college entity");
		String result= collegeService.validateAndSave(collegeentity);
		if(result!=null)
			return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/saveAll")
	public ResponseEntity<Integer> save(@RequestBody List<CollegeEntity> collegeentity) {
		logger.info("saveall  college entity return the list");
		Integer res= collegeService.validateAndSaveAll(collegeentity);
		if(res!=null)
			return new ResponseEntity<Integer>(res,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Integer>(res,HttpStatus.BAD_REQUEST);
			
	}
	
	@PutMapping("/updatebycityname")
	public ResponseEntity<String> updateByCityname(@RequestBody CollegeEntity collegeentity) {
		logger.info("update by cityname college entity");
		String res=collegeService.validateAndUpdateByCityName(collegeentity.getZipcode(), collegeentity.getCityname());
		if(res!=null)
			return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(res,HttpStatus.BAD_REQUEST);
			
	}
}
