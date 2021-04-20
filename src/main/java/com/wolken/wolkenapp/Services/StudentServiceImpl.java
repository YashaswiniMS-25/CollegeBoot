package com.wolken.wolkenapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.DTO.StudentDTO;
import com.wolken.wolkenapp.Entity.CollegeEntity;
import com.wolken.wolkenapp.Entity.StudentEntity;
import com.wolken.wolkenapp.Repository.CollegeRepo;
import com.wolken.wolkenapp.Repository.StudentRepo;
@Service
public class StudentServiceImpl  implements StudentService{
	@Autowired
	StudentRepo srepo;
	@Autowired
	CollegeRepo crepo;
	@Override
	public boolean validateAndUpdate(long smblno, String semail) {
		if(smblno!=0 && semail!=null) {
			StudentEntity entity=srepo.findBySemail(semail);
			entity.setSmblno(smblno);
			srepo.save(entity);
			return true;
			
		}
		return false;
		
	}

	@Override
	public StudentEntity validateAndUpdateNameByEmail(String sname, String semail) {
		if(sname!=null && semail!=null) {
		StudentEntity entity= srepo.findBySemail(semail);
		entity.setSname(sname);
		srepo.save(entity);
		return entity;
		}
		
		return null;
	}

	@Override
	public String validateAndSavestudent(StudentEntity entity) {
		if(entity!=null) {
			srepo.save(entity);
			return "Saved";
		}
		return "not saved";
	}

	@Override
	public StudentEntity validateAndUpdateAllByEmail(long smblno, String dob, String saddress, String semail) {
		if(semail!=null) {
		StudentEntity entity=srepo.findBySemail(semail);
		entity.setSmblno(smblno);
		entity.setDob(dob);
		entity.setSaddress(saddress);
		srepo.save(entity);
		return entity;
		}else {
			return null;
		}
	}

	@Override
	public StudentEntity saveall(StudentDTO dto) {
		CollegeEntity entity=crepo.findByZip(dto.getZip());
		if(entity!=null) {
			StudentEntity en=new StudentEntity();
			en.setSemail(dto.getSemail());
			en.setSaddress(dto.getSaddress());
			en.setSmblno(dto.getSmblno());
			en.setDob(dto.getDob());
			en.setSname(dto.getSname());
			en.setCentity(entity);
			srepo.save(en);
			crepo.save(entity);
			return en;
			
		}
		return null;
	}

	@Override
	public StudentEntity validateAndgetAllByNameOrEmail(StudentEntity entity) {
		
		return srepo.findBySnameOrSemail(entity.getSname(),entity.getSemail());
	}

	@Override
	public List<StudentEntity> validateAndgetAllByNameOrEmailOrDobOrContact(StudentEntity entity) {
		
		return srepo.findBySnameOrSemailOrDob(entity.getSname(),entity.getSemail(),entity.getDob());;
	}

}
