package com.wolken.wolkenapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.wolkenapp.Entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

	public StudentEntity findBySemail(String semail);
	public StudentEntity findBySnameOrSemail(String sname, String semail);
	public List<StudentEntity> findBySnameOrSemailOrDob(String sanme,String semail, String dob);
}
