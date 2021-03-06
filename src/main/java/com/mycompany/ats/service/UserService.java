/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ats.service;

import com.mycompany.ats.model.User;
import com.mycompany.ats.repository.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhay
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public User newUser(User user){
        return userRepo.save(user);
    }
    
    public List<User> fetchAll(){
        ArrayList<User> users=new ArrayList<>();
        for(User u:userRepo.findAll())
        {
            users.add(u);
        }
        return users;
    }
    
    public User fetch(int x){
        return userRepo.findById(x).get();
    }
    
    public User fetchByUserName(String userName){
        return userRepo.findByuserName(userName).get();
    }
    
    public int getUserCount() {
    	Iterable<User> values = userRepo.findAll();
    	if (values instanceof Collection<?>) {
    		  return ((Collection<?>)values).size();
    		}
    	return 0;
    }
    
    public int getAdminCount() {
    	int count = 0;
    	for(User user : userRepo.findAll())
    	{
    		if(user.getRoleId().getId() == 1 || user.getRoleId().getId() == 2)
    			count ++;
    	}
    	
    	return count;
    }
    
}
