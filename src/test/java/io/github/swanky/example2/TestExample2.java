package io.github.swanky.example2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class TestExample2 {

	@Test
	public void test() throws Exception {
		KieHelper kieHelper = new KieHelper();
		KieBase kieBase = kieHelper
				.addResource(ResourceFactory.newClassPathResource("io/github/swanky/example2/example2.drl")).build();

		StatelessKieSession kSession = kieBase.newStatelessKieSession();
		Applicant applicant = new Applicant("Mr John Smith", 16);
		Application application = new Application(new Date(), true);
		assertTrue(application.isValid());
		kSession.execute(Arrays.asList(new Object[] { application, applicant }));
		assertFalse(application.isValid());
	}
}
