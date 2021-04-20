package com.wolken.wolkenapp.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class StudentDTO {
	
	private String sname;
	private String semail;
	private long scontactno;
	private String saddress;
	private String sdob;
	private int zipcode;



}
