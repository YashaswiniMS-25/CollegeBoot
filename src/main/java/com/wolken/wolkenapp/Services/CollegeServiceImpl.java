package com.wolken.wolkenapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.Entity.CollegeEntity;
import com.wolken.wolkenapp.Repository.CollegeRepo;
@Service
public class CollegeServiceImpl implements CollegeService{
 @Autowired
 CollegeRepo crepo;
	@Override
	public List<CollegeEntity> getAll() {
		
		return crepo.findAll();
	}

	@Override
	public List<CollegeEntity> validateAndGetAllByCity(String cityname) {
		if (cityname != null) {
			System.out.println("inside getall by city");
			List<CollegeEntity> entity = crepo.findByCityname(cityname);

			return entity;
		} else
			return null;
	}

	@Override
	public String valiadateAndSave(CollegeEntity entity) {
		if(entity!=null) {
			crepo.save(entity);
			return "saved";
		}
		
		
		return "not saved";
	}

	@Override
	public int validateAndSaveAll(List<CollegeEntity> entity) {
		if(entity!=null) {
			List<CollegeEntity> entities=crepo.saveAll(entity);
			int n=entities.size();
			return n;
		}
		return 0;
		
		
	}

	@Override
	public List<CollegeEntity> validateAndUpdate(int zip, String cityname) {
		List<CollegeEntity> entity=crepo.findByCityname(cityname);
		if(entity!=null) {
		for(CollegeEntity en:entity) {
			en.setZip(zip);
			crepo.save(en);
		}
		return entity;
		}
		
		
		return null;
	}

	

}
