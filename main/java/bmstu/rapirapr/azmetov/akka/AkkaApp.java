package bmstu.rapirapr.azmetov.akka;

public class AkkaApp {

    public static void main(String[] args) throws Exception {
        public static final String JOB_NAME = "AkkaActorSystem";
//        if (args.length != 3) {
//            System.err.println(USAGE_ERROR_TEXT);
//            System.exit(-1);
//        }

        ActorSystem system = ActorSystem.create("akkaActorSystem");

        Props props1 = Props.create(StoreActor.class);
        ActorRef actor = system.actorOf(
                Props.create(StoreActor.class)
        );

    }
}