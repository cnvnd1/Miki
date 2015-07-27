package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.exception.UserLoginException;
import com.test.dao.RepositoyAdaptor;
import com.test.entity.user.UserDTO;
import com.test.entity.user.UserPostWriteDTO;

@Service("userService")
public class UserService extends ServiceAdaptor{
	
	@Autowired
	@Qualifier("userRepository")
	RepositoyAdaptor repo;
	
	public int userInsert(UserDTO dto) throws UserLoginException{
		return repo.userInsert(dto);
		
	}
	@Override
	public void userPostWrite(UserPostWriteDTO dto) throws UserLoginException {
		repo.userPostWrite(dto);
	}

	@Override
	public List<UserPostWriteDTO> userPostSelect() {
		
		return repo.userPostSelect();
	}
}
