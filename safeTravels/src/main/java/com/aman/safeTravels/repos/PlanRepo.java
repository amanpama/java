package com.aman.safeTravels.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aman.safeTravels.models.Plan;

@Repository
public interface PlanRepo extends CrudRepository<Plan, Long> {

	List<Plan> findAll();
}
