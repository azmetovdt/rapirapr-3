package bmstu.rapirapr.azmetov.akka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MessageTest {
    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final List<Test> tests;

    @JsonCreator
    public MessageTest() {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = funcName;
        this.tests = tests;
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

    public List<Test> getTests() {
        return this.tests;
    }
}
