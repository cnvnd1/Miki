package com.test.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exception.LoginDuplicateIdException;
import com.exception.LoginWrongPasswdException;
import com.exception.PostWriteException;
import com.exception.UserLoginException;
import com.logic.MainLogic;
import com.logic.ResultDATA;
import com.test.entity.user.UserDTO;
import com.test.entity.user.UserPostWriteDTO;
import com.test.service.ServiceAdaptor;

@Controller
public class LocationController {
	
	private static final int USERID_INPUTSUCCESS = 1;	
	
	@Autowired
	@Qualifier("mainLogicService")
	ServiceAdaptor mainService;
	
	@Autowired
	@Qualifier("mainLogic")
	MainLogic logic;
	
	Log log = LogFactory.getLog(LocationController.class);
	
	
	
	
	
}
