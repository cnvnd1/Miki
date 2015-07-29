package com.test.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.dao.RepositoyAdaptor;
import com.test.dto.BeaconWithUserIdDTO;
import com.test.dto.EventListDTO;


@Service("adminService")
public class AdminService extends ServiceAdaptor{
	
	@Autowired
	@Qualifier("adminRepository")
	RepositoyAdaptor repo;
	
	Log log = LogFactory.getLog(AdminService.class);

	public List<EventListDTO> eventListSelect() {
		
		return repo.eventListSelect();
	}
}
