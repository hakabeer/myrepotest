package com.web.app.project.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.project.model.User;
import com.web.app.project.repository.UserRepository;

/**
 * provides services for user.
 *
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {

        return userRepository.getAll();
    }
    
    @Transactional(readOnly = false)
    public User create(User user) throws ParseException {

    	return userRepository.merge(user);
        
    }
    
    
}
