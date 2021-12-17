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
    private static final String OUTPUT_INITIAL_VALUE = "";

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageTest.class, m -> sender().tell(test(m), self()))
                .build();
    }

    public String execJS(String jscript, String functionName, List<Integer> params) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }

    private TestResult test(MessageTest messageTest) {
        String status, output = OUTPUT_INITIAL_VALUE;
        try {
//            System.out.println(messageTest.getJsScript());
//            System.out.println(messageTest.getFunctionName());
//            System.out.println(messageTest.getTest().getParams());
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