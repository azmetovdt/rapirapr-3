package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.List;
import java.util.Map;

public class StoreActor extends AbstractActor {

    private Map<String, List<TestResult>> testResultsMap;

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResult.class, m -> {
                    System.out.println("receive message! "+m.toString());
                }).build();
    }

    private saveResults(String id, TestResult result) {
        
    }
}