package masteringjbpm6;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

import com.packt.masterjbpm6.pizza.model.Order;

/**
 * Without setting "jbpm.enable.multi.con" by using gateway
 */
public class SequenceTest2 extends JUnitBaseTestCase {
	public static final String[] processResources = new String[] { "sequenceflows2.bpmn" };

	public SequenceTest2() {
		super();
		setProcessResources(processResources);
	}

	@Test
	public void testMultipleConditionFlows() {
		Map<String, Object> params = new HashMap<String, Object>();
		Order order = new Order();
		order.setCost(20);
		params.put("order", order);
		ProcessInstance processInstance = ksession.startProcess("sequenceflows", params);
		assertNodeTriggered(processInstance.getId(), "start", "script", "gateway", "end1");

		params.clear();
		Order order2 = new Order();
		order2.setCost(9);
		params.put("order", order2);
		ProcessInstance processInstance2 = ksession.startProcess("sequenceflows", params);
		assertNodeTriggered(processInstance2.getId(), "start", "script", "gateway", "end2");
	}
}