package com.web.app.project.service;

import java.util.List;

import com.web.app.project.model.User;

public interface UserService {
    
   List<User> getAll() throws Exception;
   
   User create(User user) throws Exception;
   
}
