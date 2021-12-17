package bmstu.rapirapr.azmetov.akka;

public class TestResult {
    private final MessageTest messageTest;
    private final String jsScript;
    private final String functionName;
    private final Test test;

    public TestResult(
            MessageTest messageTest,

    ) {
        this.MessageTest = messageTest;
        this.jsScript = jsScript;
        this.functionName = funcName;
        this.test = test;
    }

    public TestResult(
            Message message,
            Test test
    ) {
        this.packageId = message.getPackageId();
        this.jsScript = message.getJsScript();
        this.functionName = message.getFunctionName();
        this.test = test;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getJsScript() {
        return this.jsScript;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public Test getTest() {
        return this.test;
    }
}
