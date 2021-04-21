package com.wolken.wolkenapp.Resources;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.Entity.CollegeEntity;
import com.wolken.wolkenapp.Services.CollegeService;

@RestController
@RequestMapping("/")
@Controller
public class CollegeResource {
	Logger logger=Logger.getLogger("CollegeResource");
	@Autowired 
	CollegeService cservice;
	@GetMapping("/getAll")
	public ResponseEntity<List<CollegeEntity>> getAll(){
		logger.info("inside getAll fuction");
	
		List<CollegeEntity> entity=cservice.getAll();
		if(entity!=null)
		    return new ResponseEntity<List<CollegeEntity>>(entity, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<List<CollegeEntity>>(entity,HttpStatus.BAD_REQUEST);

}
	@GetMapping("/getAllCity")
	public ResponseEntity<List<CollegeEntity>> getAllByCity(@RequestBody CollegeEntity entity){
		 logger.info("inside gett all by city name");
		List<CollegeEntity> res=cservice.validateAndGetAllByCity(entity.getCityname());
		if(res!=null)
			return new ResponseEntity<List<CollegeEntity>>(res,HttpStatus.OK);
		else
			return new ResponseEntity<List<CollegeEntity>>(res,HttpStatus.GONE);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody CollegeEntity entity) {
		logger.info("inside save");
	 String res=cservice.valiadateAndSave(entity);
	 	if(res!=null)
	 		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	 	else
	 		return new ResponseEntity<String>(res,HttpStatus.BAD_REQUEST);
		
	}
	@PostMapping("/saveAll")
	public int saveAll(@RequestBody List<CollegeEntity> entity) {
		logger.info("inside save all");
	 return cservice.validateAndSaveAll(entity);
		
		}
	
	@PutMapping("/update")
	public ResponseEntity<List<CollegeEntity>> update(@RequestBody CollegeEntity entity) {
		 			logger.info("inside update");
				List<CollegeEntity> res=cservice.validateAndUpdate(entity.getZip(),entity.getCityname());
				if(res!=null)
	
					return new ResponseEntity<List<CollegeEntity>>(res,HttpStatus.ACCEPTED);
				else
					return new ResponseEntity<List<CollegeEntity>>(res,HttpStatus.BAD_REQUEST);	
	}
}
