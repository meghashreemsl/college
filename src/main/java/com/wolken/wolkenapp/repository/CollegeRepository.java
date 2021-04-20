package com.wolken.wolkenapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wolken.wolkenapp.entity.CollegeEntity;
import com.wolken.wolkenapp.entity.StudentEntity;

public interface CollegeRepository extends JpaRepository<CollegeEntity, Integer> {
	                                           
//@Query(nativeQuery=true, value="select cf.* from studentEntity  as cf inner join collegeEntity as ce on cf.id=ce.id ")
	
public List<CollegeEntity> findByCityname(String cityname);
public CollegeEntity findByZipcode(int zipcode);



}
