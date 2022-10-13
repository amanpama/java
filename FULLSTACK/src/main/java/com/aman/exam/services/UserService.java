package com.aman.exam.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.aman.exam.models.LoginUser;
import com.aman.exam.models.User;
import com.aman.exam.repos.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "registerError", "this email is taken");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "registerError", "passwords must match");
		}
		// return errors
		if (result.hasErrors()) {
			return null;
		} else {
			// hash the passwords
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			//save to db !
			return userRepo.save(newUser);
		}
	}
	
		public User login(LoginUser newLoginObject, BindingResult result) {
			// TO-DO: Additional validations!
			Optional<User>  potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
			if(!potentialUser.isPresent()) {
				result.rejectValue("email", "loginError", "email not in database");
			} else {
				User user = potentialUser.get();
				//bcrypt checks passwords
				if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
				    result.rejectValue("password", "loginError", "Invalid Password!");
				}
				if(result.hasErrors()) {
					return null;
				} else {
					return user;
				}
				
			}
			return null;
			
	}

	// FIND ONE
	public User findOne(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);

		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

	// FIND ALL
	public List<User> allTheUsers() {
		return userRepo.findAll();
	}

}
