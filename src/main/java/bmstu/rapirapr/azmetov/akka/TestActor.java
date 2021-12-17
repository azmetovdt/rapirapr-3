package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class TestActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(Message.class, m -> {
                    System.out.println("receive message! "+m.toString());
                }).build();
    }
}