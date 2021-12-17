package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreActor extends AbstractActor {

    private Map<String, List<TestResult>> testResultsMap;

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResult.class, m -> saveResults(m.getMessageTest().getPackageId(), m))
                .build();
    }

    private void saveResults(String id, TestResult result) {
        if(!testResultsMap.containsKey(id)) {
            testResultsMap.put(id, new ArrayList<TestResult>());
        }
        testResultsMap.get(id).add(result);
    }
}