package io.github.swanky;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class Main {
	public static void main(String[] args) {
		KieHelper kieHelper = new KieHelper();
		KieBase kieBase = kieHelper
				.addResource(ResourceFactory.newClassPathResource("io/github/swanky/createRuleNotification.bpmn2"))
				.build();

		KieSession ksession = kieBase.newKieSession();
		ksession.startProcess("io.github.swanky.Create_Rule_and_Notification_Process");
	}
}
