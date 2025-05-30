package com.example.demo.services;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private  UserRepository userRepository;
 

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	
	@Override
	public boolean registerUser(User user) {

		
		try {
			
			userRepository.save(user);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
 		} 
	}

}
