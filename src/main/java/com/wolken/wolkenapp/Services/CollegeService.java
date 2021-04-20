package com.wolken.wolkenapp.Services;

import java.util.List;

import com.wolken.wolkenapp.Entity.CollegeEntity;

public interface CollegeService {

	public List<CollegeEntity> getAll();

	public List<CollegeEntity> validateAndGetAllByCity(String cityname);

	public String valiadateAndSave(CollegeEntity entity);

	public int validateAndSaveAll(List<CollegeEntity> entity);

	

	public List<CollegeEntity> validateAndUpdate(int zip, String cityname);

}
