package com.wolken.wolkenapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.dto.StudentDTO;
import com.wolken.wolkenapp.entity.CollegeEntity;
import com.wolken.wolkenapp.entity.StudentEntity;
import com.wolken.wolkenapp.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	CollegeRepository collegeRepo;
	
	@Override
	public List<CollegeEntity> validateAndgetAll() {
		return  collegeRepo.findAll();
	}

	@Override
	public List<CollegeEntity> validateAndgetAllByCityName(String cityname) {
		if(cityname!=null) {
		List<CollegeEntity> collegeentity = collegeRepo.findByCityname(cityname);
	    return collegeentity;
	}
		return null;
	}

	@Override
	public String validateAndSave(CollegeEntity collegeentity) {
		if(collegeentity!=null) {
		 collegeRepo.save(collegeentity);
		 return "data saved";
	   }
		return "data not saved";
	}

	@Override
	public int validateAndSaveAll(List<CollegeEntity> collegeentity) {
		 if(collegeentity!=null) {
			 collegeRepo.saveAll(collegeentity);
			 int num = collegeentity.size();
			 return num;
		 }
		return 0;
	}

	@Override
	public String validateAndUpdateByCityName(int zipcode, String cityname) {
	List<CollegeEntity> collegeentity = collegeRepo.findByCityname(cityname);
	if(collegeentity!= null) {
		for(CollegeEntity cen:collegeentity) {
			cen.setZipcode(zipcode);
			collegeRepo.save(cen);
		}
		return "updated";
	}
	return "failed";
	}
}

	

