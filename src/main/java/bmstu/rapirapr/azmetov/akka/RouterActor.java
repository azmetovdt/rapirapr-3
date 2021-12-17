package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

public class RouterActor extends AbstractActor {

    private final ActorRef
    public RouterActor() {

    }


    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(Message.class, m -> {
                    for (Test test : m.getTests()) {
                        System.out.println(test.getTestName());
                    }
                }).build();
    }
}