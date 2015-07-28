package com.sheduler;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:com/test/service/root-context.xml")
public class BatchServiceTest {
	
	@Autowired
	@Qualifier("batch")
	BatchService service;
	
	
	@Test
	public void testBatch() {
		service.batch();
	}

}
