package bmstu.rapirapr.azmetov.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;

import static akka.http.javadsl.server.Directives.*;
import static akka.http.javadsl.server.PathMatchers.longSegment;
import static akka.stream.impl.Pop.concat;

public class AkkaApp {
    public static final String ACTOR_SYSTEM_NAME = "AkkaActorSystem";
    public static void main(String[] args) throws Exception {
//        if (args.length != 3) {
//            System.err.println(USAGE_ERROR_TEXT);
//            System.exit(-1);
//        }

        ActorSystem system = ActorSystem.create(ACTOR_SYSTEM_NAME);

        Props props1 = Props.create(RouterActor.class);
        ActorRef actor = system.actorOf(
                Props.create(RouterActor.class)
        );

        AkkaApp app = new AkkaApp();

        Http http = Http.get(system);

    }

    private Route createRoute() {

        return route(
                path()
                get(() ->
                        pathPrefix("resut", () ->
                                path(longSegment(), (Long id) -> {

                                }))),
                post(() ->
                        path("create-order", () ->
                                entity(Jackson.unmarshaller(Order.class), order -> {
                                    CompletionStage<Done> futureSaved = saveOrder(order);
                                    return onSuccess(futureSaved, done ->
                                            complete("order created")
                                    );
                                })))
        );
    }
}