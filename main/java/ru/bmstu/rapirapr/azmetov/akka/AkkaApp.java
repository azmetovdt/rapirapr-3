package ru.bmstu.rapirapr.azmetov.akka;

public class AkkaApp {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println(USAGE_ERROR_TEXT);
            System.exit(-1);
        }

        Props props1 = Props.create(MyActor.class);
        ActorSystem system = ActorSystem.create("akkaActorSystem");
        ActorRef actor = system.actorOf(
                Props.create(StoreActor.class)
        );

    }
}