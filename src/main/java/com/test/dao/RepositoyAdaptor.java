package com.test.dao;

import java.util.List;



import com.exception.UserLoginException;
import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.user.UserDTO;
import com.test.entity.user.UserPostWriteDTO;


public class RepositoyAdaptor implements MyReposioty {

	

	@Override
	public List<BeaconWithUserIdDTO> MainLogicSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int userInsert(UserDTO dto) throws UserLoginException {
		// TODO Auto-generated method stub
		return 0;
	}
	public void userPostWrite(UserPostWriteDTO dto) throws UserLoginException {
		// TODO Auto-generated method stub
		
	}

	public List<UserPostWriteDTO> userPostSelect() {
		return null;
	}
	

}
