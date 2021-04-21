package com.wolken.wolkenapp.Resources;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.DTO.StudentDTO;
import com.wolken.wolkenapp.Entity.CollegeEntity;
import com.wolken.wolkenapp.Entity.StudentEntity;
import com.wolken.wolkenapp.Repository.StudentRepo;
import com.wolken.wolkenapp.Services.CollegeService;
import com.wolken.wolkenapp.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/")
@Controller

public class StudentResousrce {
	@Autowired 
	StudentService sservice;
	Logger logger=Logger.getLogger("StudentResousrce");
	
	@PutMapping("/updatecontact")
public boolean update(@RequestBody StudentEntity entity) {
		logger.info("inside update");
		return sservice.validateAndUpdate(entity.getSmblno(),entity.getSemail());
		
		
	}
	@PutMapping("/updatename")
	public ResponseEntity<StudentEntity> updatename(@RequestBody StudentEntity entity) {
		logger.info("inside updatename");
		StudentEntity sen=sservice.validateAndUpdateNameByEmail(entity.getSname(),entity.getSemail());
		if(sen!=null)
			return new ResponseEntity<StudentEntity>(sen,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<StudentEntity>(sen,HttpStatus.BAD_REQUEST);
			
		}
	@PostMapping("/savestudent")
	public ResponseEntity<String> save(@RequestBody StudentEntity entity)
	{
		logger.info("inside savestudent");
		String res=sservice.validateAndSavestudent(entity);
		if(res!=null)
			return new ResponseEntity<String>(res,HttpStatus.OK);
		else
			return new ResponseEntity<String>(res,HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/updatebyall")
	public ResponseEntity<StudentEntity> updateByAll(@RequestBody StudentEntity entity) {
		logger.info("inside updateByAll");
		StudentEntity res=sservice.validateAndUpdateAllByEmail(entity.getSmblno(),entity.getDob(),entity.getSaddress(),entity.getSemail());
		if(res!=null)
		 return new ResponseEntity<StudentEntity>(res,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<StudentEntity>(res,HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/saveDto")
	public ResponseEntity<StudentEntity>saveAll(@RequestBody StudentDTO dto) {
		logger.info("inside saveall");
		StudentEntity res=sservice.saveall(dto);
		if(res!=null)
			return new ResponseEntity<StudentEntity>(res,HttpStatus.OK);
		else
			return new ResponseEntity<StudentEntity>(res,HttpStatus.BAD_REQUEST);
		
	}
	@GetMapping("/getallbyname")
	public ResponseEntity<StudentEntity> getAllByCityNameOrEmail(@RequestBody StudentEntity entity) {
		StudentEntity res=sservice.validateAndgetAllByNameOrEmail(entity);
		logger.info("inside getAllByCitynameoremail");
		if(res!=null)
			return new ResponseEntity<StudentEntity>(res,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<StudentEntity>(res,HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/getAllByNameOrEmailOrDobOrContact")
	public ResponseEntity<List<StudentEntity>> getAllByNameOrEmailOrDobOrContact(@RequestBody StudentEntity entity) {
		List<StudentEntity> res=sservice.validateAndgetAllByNameOrEmailOrDobOrContact(entity);
		logger.info("inside getAllByNameOrEmailOrDobOrContact ");
		if(res!=null)
			return new ResponseEntity<List<StudentEntity>>(res,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<List<StudentEntity>>(res,HttpStatus.BAD_REQUEST);
	}
	
}
