package com.wolken.wolkenapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.dto.StudentDTO;
import com.wolken.wolkenapp.entity.CollegeEntity;
import com.wolken.wolkenapp.entity.StudentEntity;
import com.wolken.wolkenapp.repository.CollegeRepository;
import com.wolken.wolkenapp.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	Logger logger = Logger.getLogger("StudentServiceImpl");
	
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	CollegeRepository collegeRepo;

	@Override
	public boolean ValidateAndUpdateContactByEmail(long scontactno, String semail) {
		logger.info("student validate and update contact by email");
       try {
		if (scontactno != 0 && semail != null) {
			StudentEntity newstudentEntity = studentRepo.findBySemail(semail);
			newstudentEntity.setScontactno(scontactno);
			if (newstudentEntity != null) {
				studentRepo.save(newstudentEntity);
				return true;
			}
			return false;
		}
		return false;
	}catch(Exception e) {
	   logger.info("data is null");
	}
	return true;
	}

	@Override
	public StudentEntity ValidateAndUpdateNameByEmail(String sname, String semail) {
		logger.info(" student validate and update name by email ");
		
		if (sname != null && semail != null) {
			StudentEntity newstudentEntity = studentRepo.findBySemail(semail);
			newstudentEntity.setSname(sname);
			studentRepo.save(newstudentEntity);
			System.out.println("updated sucessfully");
			return newstudentEntity;
		}
		return null;
	}

	@Override
	public String validateAndSavestudent(StudentEntity studententity) {
		
		logger.info(" student validate and save student ");
		if(studententity!=null) {
			studentRepo.save(studententity);
			return "data saved";
		}
		
		return "data not saved";
	}
	@Override
	public String validateAndSaveDto(StudentDTO dto) {
		logger.info("student validate and save studentdto");
		logger.info("finding by zipcode");
		CollegeEntity collegeentity = collegeRepo.findByZipcode(dto.getZipcode());
		if(collegeentity!=null) {
		StudentEntity studententity = new StudentEntity();
		logger.info("setting student entity details");
		studententity.setSname(dto.getSname());
		studententity.setSemail(dto.getSemail());
		studententity.setSdob(dto.getSdob());
		studententity.setScontactno(dto.getScontactno());
		studententity.setSaddress(dto.getSaddress());
		studententity.setCollegeentity(collegeentity);
		studentRepo.save(studententity);
		return "update successfull";
	}
		return "update unsucessfull";

}

	@Override
	public StudentEntity validateAndgetAllByNameOrEmail(StudentEntity studententity) {
		logger.info(" student validate and get by name or email");
		return studentRepo.findBySnameOrSemail(studententity.getSname(),studententity.getSemail());
	}

	@Override
	public List<StudentEntity> validateAndgetAllByNameOrEmailOrDobOrContact(StudentEntity studententity) {
		logger.info(" student validate and get by  contact or email  or dob");
		return studentRepo.findBySnameOrSemailOrSdob(studententity.getSname(),studententity.getSemail(),studententity.getSdob());
	}
	
}
