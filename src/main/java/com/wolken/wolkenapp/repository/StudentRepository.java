package com.wolken.wolkenapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.wolkenapp.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	public StudentEntity findBySemail(String semail);

	public StudentEntity findBySnameOrSemail(String sname, String semail);

	public List<StudentEntity> findBySnameOrSemailOrSdob(String sname, String semail, String sdob);

}
