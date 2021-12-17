package bmstu.rapirapr.azmetov.akka;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;

public class AkkaApp {
    public static final String ACTOR_SYSTEM_NAME = "AkkaActorSystem";

    public static void main(String[] args) throws Exception {

        ActorSystem system = ActorSystem.create(ACTOR_SYSTEM_NAME);

        Props props1 = Props.create(RouterActor.class);
        ActorRef actor = system.actorOf(Props.create(RouterActor.class));

        ActorMaterializer materializer = ActorMaterializer.create(system);

        AkkaApp app = new AkkaApp();

        Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = app.createRoute(actor).flow(system, materializer);

        Http http = Http.get(system);

        CompletionStage<ServerBinding> binding = http.bindAndHandle(routeFlow, ConnectHttp.toHost("localhost", 8080), materializer);
        System.out.println("Сервер запущен");
        System.in.read();
        binding.thenCompose(ServerBinding::unbind).thenAccept(unbound -> system.terminate());
    }

    private Route createRoute(ActorRef actor) {

        return route(
                get(() -> parameter("packageId",
                        id -> {
                            return complete("frefre");
                        }
                )),
                post(() -> entity(Jackson.unmarshaller(Message.class),
                        order -> {
                            return complete(order.getFunctionName());
                        }
                ))
        );
    }
}