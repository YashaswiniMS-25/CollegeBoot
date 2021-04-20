package com.wolken.wolkenapp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="college_table")
public class CollegeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="cname")
	private String cname;
	@Column(name="cityname")
	private String cityname;
	@Column(name="zip")
	private int zip;
	
	@OneToOne
	  @PrimaryKeyJoinColumn
	//@JoinColumn(name="id")
	@JsonIgnoreProperties("centity")
	private StudentEntity sentity;
	
	

}
