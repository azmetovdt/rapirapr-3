package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class RouterActor extends AbstractActor {

    private final ActorRef tester;

    public RouterActor() {
        tester = getContext().actorOf(Props.create(TestActor.class));
    }


    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(Message.class, m -> {
                    for (Test test : m.getTests()) {
                        tester.tell();
                    }
                }).build();
    }
}