package io.github.swanky;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RuleService {
	public String createRule(String deviceId, String targetId) {
		log.info("Creating Rule - deviceId: " + deviceId + ", targetId:" + targetId);
		String ruleId = "RULE_ID";
		log.info("Create Rule Success - ruleId: " + ruleId);
		return ruleId;
	}
}
