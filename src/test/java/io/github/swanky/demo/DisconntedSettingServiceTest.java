package io.github.swanky.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class DisconntedSettingServiceTest {

	DisconntedSettingService service;
	
	@Before
	public void init(){
		service = new DisconntedSettingService();
	}
	
	@Test
	public void testCreateDisconnectedRule() throws Exception {
		String deviceId = "RS06000D6F0001734C8A";
		String email = "swanky@insnergy.com";

		String ruleId = service.createDisconnectedRule(deviceId, email);
		assertNotNull(ruleId);
	}

}
