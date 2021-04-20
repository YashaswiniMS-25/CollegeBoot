package com.wolken.wolkenapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wolken.wolkenapp.Entity.CollegeEntity;

public interface CollegeRepo extends JpaRepository<CollegeEntity, Integer> {
	//@Query(nativeQuery=true, value="select cd.* from StudentEntity as cd inner join CollegeEntity as ce on cd.id=ce.id")
		public List<CollegeEntity> findByCityname(String cityname);
		public CollegeEntity findByZip(int zip);
}
