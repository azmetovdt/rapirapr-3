package bmstu.rapirapr.azmetov.akka;

public class MessageTest {
    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final Test test;

    public MessageTest(
            String packageId,
            String jsScript,
            String funcName,
            Test test
    ) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = funcName;
        this.test = test;
    }

    public MessageTest(
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
