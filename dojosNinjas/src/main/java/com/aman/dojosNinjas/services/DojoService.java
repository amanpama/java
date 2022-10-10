package com.aman.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.dojosNinjas.models.Dojo;
import com.aman.dojosNinjas.repos.DojoRepo;

@Service
public class DojoService {

	@Autowired
	private DojoRepo dojoRepo;

	// READ ALL
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}

	// CREATE
	public Dojo createDojo(Dojo b) {
		return dojoRepo.save(b);
	}

	// find ONE
		public Dojo findDojo(Long id) {
			Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		
		
			if(optionalDojo.isPresent()){
				return optionalDojo.get();
			} 	else {
					return null;
			}
		}
		
		
		//UPDATE PAGE
		public Dojo updateDojo(Dojo d) {
			Dojo updateDojo = dojoRepo.save(d);
			return updateDojo;
		}
		
		//delete
		public void deleteDojo(Long id){
			dojoRepo.deleteById(id);
			
		}
	
}
