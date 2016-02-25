package org.bpms;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class Main {
	public static void main(String[] args) {
		KieHelper kieHelper = new KieHelper();
		KieBase kieBase = kieHelper.addResource(ResourceFactory.newClassPathResource("org/bpms/HelloWorld.bpmn2"))
				.addResource(ResourceFactory.newClassPathResource("org/bpms/helloworldrule.drl")).build();

		KieSession ksession = kieBase.newKieSession();
		ksession.startProcess("org.bpms.HelloWorld");
		ksession.fireAllRules();
	}
}
