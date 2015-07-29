package com.test.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.test.dto.BeaconWithUserIdDTO;
import com.test.dto.EventListDTO;

@Repository("adminRepository")
public class AdminRepository extends RepositoyAdaptor{
	
	Log log = LogFactory.getLog(AdminRepository.class);
	
	@Autowired
	@Qualifier("sessionTemplete")
	SqlSessionTemplate template;
	
	public List<EventListDTO> eventListSelect() {
		// TODO Auto-generated method stub
		return template.selectList("event.eventList");
	}
}
