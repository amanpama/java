package com.aman.safeTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.safeTravels.models.Plan;
import com.aman.safeTravels.repos.PlanRepo;

@Service
public class PlanService {

	@Autowired
	private PlanRepo planRepo;

	// READ ALL
	public List<Plan> allPlans() {
		return planRepo.findAll();
	}

	// CREATE
	public Plan createPlan(Plan b) {
		return planRepo.save(b);
	}

	// READ ONE
		public Plan findPlan(Long id) {
			Optional<Plan> optionalPlan = planRepo.findById(id);
		
		
			if(optionalPlan.isPresent()){
				return optionalPlan.get();
			} 	else {
					return null;
			}
		}
		
		
		//UPDATE PAGE
		public Plan updatePlan(Plan p) {
			Plan updatePlan = planRepo.save(p);
			return updatePlan;
		}
		
		//delete
		public void deletePlan(Long id){
			planRepo.deleteById(id);
			
		}
		
		
		
	}
