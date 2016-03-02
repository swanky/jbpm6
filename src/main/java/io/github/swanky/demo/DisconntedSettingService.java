package io.github.swanky.demo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jbpm.ruleflow.instance.RuleFlowProcessInstance;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisconntedSettingService {

	private static final String PROCESS_DEF = "io/github/swanky/demo/createDisconnectedRule.bpmn2";
	private static final String PROCESS_NAME = "io.github.swanky.demo.Create_Disconnected_Rule_Process";

	private KieBase kieBase;

	public DisconntedSettingService() {
		KieHelper kieHelper = new KieHelper();
		kieBase = kieHelper.addResource(ResourceFactory.newClassPathResource(PROCESS_DEF)).build();
	}

	public String createDisconnectedRule(String deviceId, String email) {
		log.info("Strat Process [" + PROCESS_NAME + "] - deviceId: " + deviceId + ", email: " + email);

		KieSession ksession = kieBase.newKieSession();

		Map<String, Object> param = new LinkedHashMap<String, Object>();
		param.put("deviceId", deviceId);
		param.put("email", email);

		ProcessInstance pi = ksession.startProcess(PROCESS_NAME, param);

		RuleFlowProcessInstance rfpi = (RuleFlowProcessInstance) pi;
		String ruleId = (String) rfpi.getVariable("ruleId");
		if (rfpi.getState() == ProcessInstance.STATE_COMPLETED) {
			log.info(String.format("Process \"%s\" is COMPLETED", rfpi.getProcessName()));
		}
		log.info("RuleId: " + ruleId);
		return ruleId;
	}
}
