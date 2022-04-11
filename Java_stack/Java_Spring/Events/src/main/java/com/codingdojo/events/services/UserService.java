package com.codingdojo.events.services;

import java.util.List;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.codingdojo.events.models.LoginUser;
import com.codingdojo.events.models.User;
import com.codingdojo.events.repositories.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public List<User> allUsers(){
        return userRepo.findAll();
    }
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        
        // TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        if(potentialUser.isPresent()) {
            result.rejectValue("email", "Exist", "This email already exist!");
            return null;
        }		
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
            return null;
        }
        if (result.hasErrors()) {
        	 return null;
        }else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
        // Hash and set password, save user to database
        
        }

    public User login(LoginUser newLoginObject, BindingResult result) {
    	if (result.hasErrors()) {
    		return null;
    	}
        Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        if(potentialUser.isEmpty()) {
            result.rejectValue("email", "notExist", "Register First!");
            return null;
        }
        
        User logUser = potentialUser.get();
        if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
            return null;
        }
        // Return null if result has errors
        if (result.hasErrors()) {
    		return null;
    	}
        else {
            return logUser;
        }
        
    }
    
    public User newUser(User newUser) {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);

        
        }
}