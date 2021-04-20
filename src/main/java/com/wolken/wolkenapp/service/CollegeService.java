package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.entity.CollegeEntity;

public interface CollegeService {
	
	public List<CollegeEntity> validateAndgetAll();

	public List<CollegeEntity> validateAndgetAllByCityName(String cityname);

	public String validateAndSave(CollegeEntity collegeentity);

	public int validateAndSaveAll(List<CollegeEntity> collegeentity);
	
	public String validateAndUpdateByCityName(int zipcode, String cityname);

	

}
