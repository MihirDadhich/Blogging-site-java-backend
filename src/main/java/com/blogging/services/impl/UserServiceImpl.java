package com.blogging.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogging.entities.User;
import com.blogging.exceptions.ResourceNotFoundException;
import com.blogging.payloads.UserDto;
import com.blogging.repositories.UserRepo;
import com.blogging.services.UserService;

public class UserServiceImpl implements UserService {

	
	@Autowired 
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user= this.dtoToUser(userDto); 
		User savedUser =this.userRepo.save(user);
		return this.userToDto(savedUser);
	}
 
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user =this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User"," Id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser=this.userRepo.save(user);
      	return this.userToDto(updatedUser);		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user =this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User"," Id ", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users =this.userRepo.findAll();
				
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}
	
	private User dtoToUser(UserDto userDto) {
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		return user;
		
	}
	
	public UserDto userToDto (User user) {
		UserDto userDto= new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getPassword());
		
		return userDto;
	}

}
