package com.wolken.wolkenapp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="student_table")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="sname")
	private String sname;
	
	@Column(name="saddress")
	private String saddress;
	@Column(name="semail")
	private String semail;
	@Column(name="smblno")
	private long smblno;
	@Column(name="dob")
	private String dob;
	
	@OneToOne
	@JsonIgnoreProperties("sentity")
	private CollegeEntity centity;
	
	
	

}
