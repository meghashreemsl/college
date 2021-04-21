package com.wolken.wolkenapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.entity.CollegeEntity;

import com.wolken.wolkenapp.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {

	Logger logger = Logger.getLogger("CollegeServiceImpl");
	@Autowired
	CollegeRepository collegeRepo;
	
	@Override
	public List<CollegeEntity> validateAndgetAll() {
		logger.info("inisde validate and get all of college entity");
	try {
		return  collegeRepo.findAll();
		}catch(Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<CollegeEntity> validateAndgetAllByCityName(String cityname) {
		logger.info("inside validate and get by cityname");
		try {
		if(cityname!=null) {
		List<CollegeEntity> collegeentity = collegeRepo.findByCityname(cityname);
	    return collegeentity;
	}
		return null;
	}catch(Exception e){
		e.getMessage();
	}
		return null;
	}

	@Override
	public String validateAndSave(CollegeEntity collegeentity) {
		logger.info("inside validate and save college entity");
		try {
		if(collegeentity!=null) {
		 collegeRepo.save(collegeentity);
		 return "data saved";
	   }
		return "data not saved";
	}catch(Exception e) {
		e.getMessage();
	}
		return null;
	}

	@Override
	public Integer validateAndSaveAll(List<CollegeEntity> collegeentity) {
		logger.info("inside validate and save college entity");
		 if(collegeentity!=null) {
			 collegeRepo.saveAll(collegeentity);
			 Integer num = collegeentity.size();
			 return num;
		 }
		return 0;
	}

	@Override
	public String validateAndUpdateByCityName(int zipcode, String cityname) {
	logger.info("inside validate by city name");
	try {
	List<CollegeEntity> collegeentity = collegeRepo.findByCityname(cityname);
	if(collegeentity!= null) {
		for(CollegeEntity cen:collegeentity) {
			cen.setZipcode(zipcode);
			collegeRepo.save(cen);
		}
		return "updated";
	}
	return "failed";
	}catch(Exception e) {
		e.getMessage();
	}
	return cityname;
	}
}

	

