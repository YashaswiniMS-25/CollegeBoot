package com.wolken.wolkenapp.Services;

import java.util.List;

import com.wolken.wolkenapp.DTO.StudentDTO;
import com.wolken.wolkenapp.Entity.StudentEntity;

public interface StudentService {

	public boolean validateAndUpdate(long smblno, String semail);

	public StudentEntity validateAndUpdateNameByEmail(String sname, String semail);

	public String validateAndSavestudent(StudentEntity entity);

	public StudentEntity validateAndUpdateAllByEmail(long smblno, String dob, String saddress, String semail);

	public StudentEntity saveall(StudentDTO dto);

	public StudentEntity validateAndgetAllByNameOrEmail(StudentEntity entity);

	public List<StudentEntity> validateAndgetAllByNameOrEmailOrDobOrContact(StudentEntity entity);

}
