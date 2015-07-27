package com.test.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exception.UserLoginException;
import com.test.entity.user.UserDTO;
import com.test.entity.user.UserPostWriteDTO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:com/test/service/root-context.xml")
public class UserServiceTest {
	
	@Autowired
	@Qualifier("userService")
	ServiceAdaptor userService;
	Log log = LogFactory.getLog(UserServiceTest.class);
	//@Test
	public void testUserInsert() {
		
		UserDTO dto = new UserDTO("login","cdd", "1234");
		int result=0;
		try {
			result = userService.userInsert(dto);
		} catch (UserLoginException e) {
			log.info(e.getMessage());
		}
		assertThat(result,is(0));
	}
	@Test
	public void testUserPostSelect(){
		List<UserPostWriteDTO> list = userService.userPostSelect();
		assertThat(list.size(),is(13));
	}

}
