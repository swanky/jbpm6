package io.github.swanky.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationService {

	public String createTarget(String email) {
		log.info("Creating Target - email: " + email);
		String targetId = "TARGET_ID";
		log.info("Create Target Success - targetId: " + targetId);
		return targetId;
	}
}
