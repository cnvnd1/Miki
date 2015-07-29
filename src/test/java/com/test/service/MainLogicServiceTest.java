package com.test.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.logic.InvalidDTOType;
import com.logic.MainLogic;
import com.logic.ResultDATA;
import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.result.MTimePerBeaconUserInfo;
import com.test.entity.result.ResultDTO;
import com.test.entity.use.BeaconUserInfoDTO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:com/test/service/root-context.xml")
public class MainLogicServiceTest {
	
	@Autowired
	@Qualifier("mainLogicService")
	ServiceAdaptor mainLogicService;
	Log log = LogFactory.getLog(MainLogicServiceTest.class);
	@Autowired
	@Qualifier("mainLogic")
	MainLogic logic;
	
	
	@Test
	public void testMainLogicSelectAll() throws InvalidDTOType {
		log.info("testSelectAll 실행~~~");
		List<BeaconWithUserIdDTO> list = mainLogicService.MainLogicSelectAll();
		// 메인 로직 테스트 준비
		logic.setInputList(list);
		ResultDATA result = logic.makeResultDTO();
		/*// 현재 날짜 보다 이전 이용자 이름 확인
		Set<String> data = result.getYestdayUser();
		Iterator<String> ite = data.iterator();
		while (ite.hasNext()) {
			log.info(">>>>>>>>>> userId : " + ite.next());
		}
		// 사용자 아이디별 입력 확인
		HashMap<String, ResultDTO> userResult = result.getUserResultData();
		log.info(userResult.size());
		Set<String> userKey = userResult.keySet();
		Iterator<String> ite2 = userKey.iterator();
		while (ite2.hasNext()) {
			log.info(">>>>>>>>>> userId2 : " + ite2.next());
		}
*/
		// 날짜별 아이디 입력확인
		HashMap<String, ResultDTO> timeResult = result.getmTimeResultData();
		log.info(timeResult.size());
		Set<String> timeKey = timeResult.keySet();
		Iterator<String> ite3 = timeKey.iterator();
		while (ite3.hasNext()) {
			log.info(">>>>>>>>>> mtime : " + timeResult.get(ite3.next()).getSize() );
		}
		
/*
		// 비콘별 아이디 입력확인
		HashMap<String, ResultDTO> beaconIdResult = result.getBeaconResultData();
		log.info(beaconIdResult.size());
		Set<String> beaconKey = beaconIdResult.keySet();
		Iterator<String> ite4 = beaconKey.iterator();
		while (ite4.hasNext()) {
			log.info(">>>>>>>>>> beaconId : " + ite4.next());
		}*/
	}	
}

