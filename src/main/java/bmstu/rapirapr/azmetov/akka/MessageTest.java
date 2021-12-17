package bmstu.rapirapr.azmetov.akka;

public class MessageTest {
    private final Message message;
    private final Test test;

    public MessageTest(
            Message message,
            Test test
    ) {
        this.message = message;
        this.test = test;
    }

    public String getPackageId() {
        return this.message.getPackageId();
    }

    public String getJsScript() {
        return this.message.getJsScript();
    }

    public String getFunctionName() {
        return this.message.getFunctionName();
    }

    public Test getTest() {
        return this.test;
    }

    @Override
    public String toString() {
        return "MessageTest{" +
                "message=" + message.toString() + '\n' +
                ", test=" + test.toString() + '\n' +
                '}';
    }
}
