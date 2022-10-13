package com.aman.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.exam.models.Baby;
import com.aman.exam.repos.BabyRepo;



@Service
public class BabyService {

	@Autowired
	private BabyRepo babyRepo;

	// READ ALL
	public List<Baby> allBabys() {
		return babyRepo.findAll();
	}

	// CREATE
	public Baby createBaby(Baby b) {
		return babyRepo.save(b);
	}

	// READ ONE
		public Baby findBaby(Long id) {
			Optional<Baby> optionalBaby = babyRepo.findById(id);
		
		
			if(optionalBaby.isPresent()){
				return optionalBaby.get();
			} 	else {
					return null;
			}
		}
		
		
		//UPDATE PAGE
		public Baby updateBaby(Baby p) {
			Baby updateBaby = babyRepo.save(p);
			return updateBaby;
		}
		
		//delete
		public void deleteBaby(Long id){
			babyRepo.deleteById(id);
			
		}
		
		
		
	}
