package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class RouterActor extends AbstractActor {

    private final ActorRef saver;
    private final ActorRef tester;

    public RouterActor() {
        saver = getContext().actorOf(Props.create(StoreActor.class));
        tester = getContext().actorOf(Props.create(TestActor.class));
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(Message.class, message -> {
                    for (Test test : message.getTests()) {
                        tester.tell(new MessageTest(message, test), saver);
                    }
                })
                .match(String.class, id -> saver.tell(id, sender()))
                .build();
    }
}