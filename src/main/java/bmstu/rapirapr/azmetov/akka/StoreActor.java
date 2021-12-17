package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreActor extends AbstractActor {

    private final Map<String, List<TestResult>> testResultsMap = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResult.class, m -> saveResults(m.getMessageTest().getPackageId(), m))
                .match(String.class, this::getProgramResults)
                .build();
    }

    private void saveResults(String id, TestResult result) {
        if (!testResultsMap.containsKey(id)) {
            testResultsMap.put(id, new ArrayList<>());
        }
        testResultsMap.get(id).add(result);
    }

    private List<TestResult> getProgramResults(String id) {
        return testResultsMap.get(id);
    }
}