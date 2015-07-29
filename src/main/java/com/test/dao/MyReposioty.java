package com.test.dao;

import java.util.List;




import com.exception.UserLoginException;
import com.test.dto.BeaconWithUserIdDTO;
import com.test.dto.EventListDTO;
import com.test.entity.user.UserDTO;
import com.test.entity.user.UserPostWriteDTO;

public interface MyReposioty {


	public List<BeaconWithUserIdDTO> MainLogicSelectAll();
	public int userInsert(UserDTO dto) throws UserLoginException;
	public void userPostWrite(UserPostWriteDTO dto) throws UserLoginException;
	public List<UserPostWriteDTO> userPostSelect();
	public List<EventListDTO> eventListSelect();
}