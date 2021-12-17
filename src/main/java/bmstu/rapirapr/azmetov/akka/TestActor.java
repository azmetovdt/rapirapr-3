package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class TestActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageTest.class, m -> {
                    System.out.println("receive message! "+m.toString());
                }).build();
    }

    public execJS() {
        ScriptEngine engine = new
                ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }
}