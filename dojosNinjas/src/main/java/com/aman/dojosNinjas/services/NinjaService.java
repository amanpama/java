package com.aman.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.dojosNinjas.models.Ninja;
import com.aman.dojosNinjas.repos.NinjaRepo;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepo ninjaRepo;

	// READ ALL
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}

	// CREATE
	public Ninja createNinja(Ninja b) {
		return ninjaRepo.save(b);
	}

	// READ ONE
		public Ninja findNinja(Long id) {
			Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		
		
			if(optionalNinja.isPresent()){
				return optionalNinja.get();
			} 	else {
					return null;
			}
		}
		
		
		//UPDATE PAGE
		public Ninja updateNinja(Ninja d) {
			Ninja updateNinja = ninjaRepo.save(d);
			return updateNinja;
		}
		
		//delete
		public void deleteNinja(Long id){
			ninjaRepo.deleteById(id);
			
		}
	
}
