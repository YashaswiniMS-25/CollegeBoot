package com.wolken.wolkenapp.Services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.Entity.CollegeEntity;
import com.wolken.wolkenapp.Exception.CityException;
import com.wolken.wolkenapp.Exception.GetAllException;
import com.wolken.wolkenapp.Repository.CollegeRepo;
@Service
public class CollegeServiceImpl implements CollegeService{
 @Autowired
 CollegeRepo crepo;
 Logger logger=Logger.getLogger("CollegeServiceImpl");
	@Override
	public List<CollegeEntity> getAll() {
		logger.info("inside getall");
		try {
		return crepo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return crepo.findAll();
		
		
	}

	@Override
	public List<CollegeEntity> validateAndGetAllByCity(String cityname) {
		try {
		if (cityname != null) {
			System.out.println("inside getall by city");
			List<CollegeEntity> entity = crepo.findByCityname(cityname);
			logger.info("find by cityname");

			return entity;
		} else
			throw new CityException();
		}catch(Exception e) {
			e.getMessage();
		}
		return crepo.findByCityname(cityname);
	}

	@Override
	public String valiadateAndSave(CollegeEntity entity) {
		try {
		if(entity!=null) {
			logger.info("validate and save");
			crepo.save(entity);
			logger.info("data is saved");
			return "saved";
		}else
		return "not saved";
	}catch(Exception e) {
		e.getMessage();
		}
		return "not saved";
		
	}
	

	@Override
	public int validateAndSaveAll(List<CollegeEntity> entity) {
		try {
		if(entity!=null) {
			logger.info("inside entity is not null");
			List<CollegeEntity> entities=crepo.saveAll(entity);
			logger.info("saveAll");
			int n=entities.size();
			return n;
		}else {
		return 0;}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public List<CollegeEntity> validateAndUpdate(int zip, String cityname) {
		logger.info("validate and update");
		List<CollegeEntity> entity=crepo.findByCityname(cityname);
		logger.info("find by city name");
		if(entity!=null) {
			logger.info("entity is not null");
		for(CollegeEntity en:entity) {
			logger.info("inside for loop");
			en.setZip(zip);
			crepo.save(en);
		}
		return entity;
		}
		
		
		return null;
	}

	

}
