package bmstu.rapirapr.azmetov.akka;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

public class TestActor extends AbstractActor {

    private static final String TEST_PASSED_STATUS = "PASSED";
    private static final String TEST_FAILED_STATUS = "FAILED";
    private static final String EXECUTION_FAILED_STATUS = "PASSED";

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageTest.class, m -> {
                    System.out.println("receive message! " + m.toString());
                }).build();
    }

    public String execJS(String jscript, String functionName, List<Integer> params) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }

    private test(MessageTest test) {
        String result;
        try {
            result = execJS(test.getJsScript(), test.getFunctionName(), test.getTest().getParams());
        } catch ()
    }
}