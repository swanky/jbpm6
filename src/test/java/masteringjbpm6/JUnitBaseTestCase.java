package masteringjbpm6;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Before;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;

public class JUnitBaseTestCase extends JbpmJUnitBaseTestCase {
	public static KieSession ksession = null;
	public static RuntimeEngine engine = null;

	private String[] processResources = null;

	protected RuntimeManager rtm;

	public void setProcessResources(String... processResource) {
		this.processResources = processResource;
	}

	@Before
	public void initWf() {
		try {
			rtm = super.createRuntimeManager(processResources);
			engine = super.getRuntimeEngine();
			ksession = engine.getKieSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}