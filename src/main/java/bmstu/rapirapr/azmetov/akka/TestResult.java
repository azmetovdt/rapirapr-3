package bmstu.rapirapr.azmetov.akka;

public class TestResult {
    private final MessageTest messageTest;
    private final String status;
    private final String output;

    public TestResult(
            MessageTest messageTest,
            String status,
            String output
            ) {
        this.messageTest = messageTest;
        this.status = status;
        this.output = output;
    }

    public MessageTest getMessageTest() {
        return this.messageTest;
    }

    public String getStatus() {
        return this.status;
    }

    public String getOutput() {
        return this.output;
    }



}
