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
    private static final String ENGINE_NAME = "nashorn";
    private static final String OUTPUT_INITIAL_VALUE = "";

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageTest.class, messageTest -> sender().tell(test(messageTest), self()))
                .build();
    }

    public String execJS(String jscript, String functionName, List<Integer> params) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(ENGINE_NAME);
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params.toArray()).toString();
    }

    private TestResult test(MessageTest messageTest) {
        String status, output = OUTPUT_INITIAL_VALUE;
        try {
            output = execJS(messageTest.getJsScript(), messageTest.getFunctionName(), messageTest.getTest().getParams());
            status = isOutputCorrect(messageTest, output) ? TEST_PASSED_STATUS : TEST_FAILED_STATUS;
        } catch (ScriptException | NoSuchMethodException e) {
            status = EXECUTION_FAILED_STATUS;
        }
        return new TestResult(messageTest, status, output);
    }

    private static boolean isOutputCorrect(MessageTest messageTest, String output) {
        return messageTest.getTest().getExpectedResult().equals(output);
    }
}