package io.github.swanky.example1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class TestExample1 {

	@Test
	public void test() throws Exception {
		KieHelper kieHelper = new KieHelper();
		KieBase kieBase = kieHelper
				.addResource(ResourceFactory.newClassPathResource("io/github/swanky/example1/example1.drl")).build();

		StatelessKieSession kSession = kieBase.newStatelessKieSession();
		Applicant applicant = new Applicant("Mr John Smith", 16, true);
		assertTrue(applicant.isValid());
		kSession.execute(applicant);
		assertFalse(applicant.isValid());
	}

}
