package com.wolken.wolkenapp.Services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.DTO.StudentDTO;
import com.wolken.wolkenapp.Entity.CollegeEntity;
import com.wolken.wolkenapp.Entity.StudentEntity;
import com.wolken.wolkenapp.Exception.SaveException;
import com.wolken.wolkenapp.Exception.UpdateException;
import com.wolken.wolkenapp.Repository.CollegeRepo;
import com.wolken.wolkenapp.Repository.StudentRepo;
@Service
public class StudentServiceImpl  implements StudentService{
	Logger logger=Logger.getLogger("StudentServiceImpl");
	@Autowired
	StudentRepo srepo;
	@Autowired
	CollegeRepo crepo;
	@Override
	public boolean validateAndUpdate(long smblno, String semail) {
		logger.info("inside validate and update ");
		try {
		if(smblno!=0 && semail!=null) {
			logger.info("mblno is valid");
			StudentEntity entity=srepo.findBySemail(semail);
			logger.info("findBySemail");
			entity.setSmblno(smblno);
			logger.info("setting mail");
			srepo.save(entity);
			logger.info("saved");
			return true;
			
		}else {
			throw new UpdateException();
			
		}
		}catch(UpdateException e) {
			e.printStackTrace();
			}
		return false;
		
	}

	@Override
	public StudentEntity validateAndUpdateNameByEmail(String sname, String semail) {
		try {
		if(sname!=null && semail!=null) {
			logger.info("inside update name by email");
		StudentEntity entity= srepo.findBySemail(semail);
		logger.info("findByemail");
		entity.setSname(sname);
		logger.info("settting name");
		srepo.save(entity);
		logger.info("save");
		return entity;
		}else {
			throw new UpdateException();
		}
		}catch(UpdateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String validateAndSavestudent(StudentEntity entity) {
		try {
		if(entity!=null) {
			logger.info("insidevalidatesavestudent");
			srepo.save(entity);
			logger.info("save");
			return "Saved";
		}else {
		return "not saved";
		
		}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return "not saved";
		
	}

	@Override
	public StudentEntity validateAndUpdateAllByEmail(long smblno, String dob, String saddress, String semail) {
		try {
		if(semail!=null) {
			logger.info("valiadte and update all by email");
		StudentEntity entity=srepo.findBySemail(semail);
		logger.info("findbysemail");
		entity.setSmblno(smblno);
		
		entity.setDob(dob);
		entity.setSaddress(saddress);
		srepo.save(entity);
		return entity;
		}else {
			//return null;
			throw new UpdateException();
		}}catch(UpdateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StudentEntity saveall(StudentDTO dto) {
		CollegeEntity entity=crepo.findByZip(dto.getZip());
		try {
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
			
		}else {
			throw new SaveException();
		}}catch(SaveException e) {e.printStackTrace();}
		return null;
	}

	@Override
	public StudentEntity validateAndgetAllByNameOrEmail(StudentEntity entity) {
		
		return srepo.findBySnameOrSemail(entity.getSname(),entity.getSemail());
	}

	@Override
	public List<StudentEntity> validateAndgetAllByNameOrEmailOrDobOrContact(StudentEntity entity) {
		
		return srepo.findBySnameOrSemailOrDob(entity.getSname(),entity.getSemail(),entity.getDob());
	}

}
