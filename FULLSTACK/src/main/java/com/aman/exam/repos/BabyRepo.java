package com.aman.exam.repos;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aman.exam.models.Baby;

@Repository
public interface BabyRepo extends CrudRepository<Baby, Long> {
	List<Baby> findAll();
}
