package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dto.EventListDTO;
import com.test.dto.result.EventListResultDTO;
import com.test.service.ServiceAdaptor;

@Controller
public class AdminController {
	
	@Autowired
	@Qualifier("adminService")
	ServiceAdaptor adminService;
	
	Log log = LogFactory.getLog(AdminController.class);
	
	@RequestMapping("/eventList")
	@ResponseBody
	public List<EventListDTO> eventListSelect(){
		log.info("eventListSelect 실행");
	
		List<EventListDTO> list = adminService.eventListSelect();
		return list;
	}
	
}
