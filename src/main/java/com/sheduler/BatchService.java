package com.sheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("batch")
public class BatchService {
	static final Log log = LogFactory.getLog(BatchService.class);
	@Scheduled(fixedDelay=5000)
	public void batch(){
		for(int i = 0; i < 10; i++){
			log.info(">>>>>>" + i);
		}
	}
}
