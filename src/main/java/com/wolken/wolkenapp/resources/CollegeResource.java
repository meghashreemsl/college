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
import com.wolken.wolkenapp.entity.CollegeEntity;
import com.wolken.wolkenapp.service.CollegeService;
@RequestMapping("/")
@RestController
@Controller
public class CollegeResource {
	
	@Autowired
	CollegeService collegeService;
	
	@GetMapping("/getAllce")
	public List<CollegeEntity> getAll(@RequestBody CollegeEntity collegeentity){
		return collegeService.validateAndgetAll();
	}
	
	@GetMapping("/getAllByCityname")
	public List<CollegeEntity> getAllByCityName(@RequestBody CollegeEntity collegeentity){
		return collegeService.validateAndgetAllByCityName(collegeentity.getCityname());
	}
	 
	@PostMapping("/savecollege")
	public String save(@RequestBody CollegeEntity collegeentity) {
		return collegeService.validateAndSave(collegeentity);
	}
	
	
	@PostMapping("/saveAll")
	public int save(@RequestBody List<CollegeEntity> collegeentity) {
		return collegeService.validateAndSaveAll(collegeentity);
	}
	
	@PutMapping("/updatebycityname")
	public String updateByCityname(@RequestBody CollegeEntity collegeentity) {
		return collegeService.validateAndUpdateByCityName(collegeentity.getZipcode(), collegeentity.getCityname());
	}
	

}
