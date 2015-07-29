package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exception.LoginDuplicateIdException;
import com.exception.LoginWrongPasswdException;
import com.exception.PostWriteException;
import com.exception.UserLoginException;
import com.test.entity.user.UserDTO;
import com.test.entity.user.UserPostWriteDTO;
import com.test.service.ServiceAdaptor;

@Controller
public class UserController {
	private static final int USERID_INPUTSUCCESS = 1;	
	
	private static final Log log = LogFactory.getLog(UserController.class);
	@Autowired
	@Qualifier("userService")
	ServiceAdaptor userService;
	
	@RequestMapping("/aaa")
	@ResponseBody
	public String aaa(){
		return "aaa";
	}
	
	@RequestMapping(value = "/postListSelect" ,method=RequestMethod.GET)
	@ResponseBody
	public  List<UserPostWriteDTO> postListSelect(){
		log.info("index() 실행 >>>>>>>>>>>");	
		List<UserPostWriteDTO> postList = userService.userPostSelect();
		return postList;
	}

	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mav){
		log.info("index() 실행 >>>>>>>>>>>");	
		List<UserPostWriteDTO> postList = userService.userPostSelect();
		mav.addObject("postList",postList);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("login")
	public ModelAndView login(UserDTO dto,ModelAndView mav,HttpSession session){
		
		int result = 0 ;
		try {
			result = userService.userInsert(dto);
		} catch (UserLoginException e) {
			if(e instanceof LoginWrongPasswdException){
				session.setAttribute("errorMsg", ((LoginWrongPasswdException)e).getMessage());
			}
			if(e instanceof LoginDuplicateIdException){
				session.setAttribute("errorMsg", ((LoginDuplicateIdException)e).getMessage());
			}	
			mav.setViewName("redirect:loginForm");
			return mav;
			
		}
		if(USERID_INPUTSUCCESS == result){
			//쿠키에 저장 
			log.info("가입성공 ");
			mav.setViewName("redirect:/index");
			session.setAttribute("userId", dto.getUserId());
			return mav;
		}else{
			log.info("가입실패");
			mav.setViewName("redirect:loginForm");
			return mav;
		}
	
	}
	@RequestMapping(value ="postWrite",method = RequestMethod.POST)
	public ModelAndView write(UserPostWriteDTO dto, ModelAndView mav){
		
		try {
			userService.userPostWrite(dto);
		} catch (UserLoginException e) {
			if(e instanceof PostWriteException){
				mav.addObject("errorMsg", ((PostWriteException)e).getMessage());
			}
		}
		mav.setViewName("redirect:/index");
		return mav;
	}
	
	
}
