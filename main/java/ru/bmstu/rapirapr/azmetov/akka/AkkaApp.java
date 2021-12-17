package ru.bmstu.rapirapr.azmetov.akka;

public class AkkaApp {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println(USAGE_ERROR_TEXT);
            System.exit(-1);
        }
        ActorSystem system = ActorSystem.create("akkaActorSystem")
    }
}