package bmstu.rapirapr.azmetov.akka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Message {
    private final String PACKAGE_ID_ALIAS = "testName";
    private final String JS_SCRIPT_ALIAS = "expectedResult";
    private final String FUNCTION_NAME_ALIAS = "params";
    

    private final String packageId;
    private final String jsScript;
    private final String funcName;
    private final List<Test> tests;

    @JsonCreator
    public Message(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("jsScript") String jsScript,
            @JsonProperty("functionName") String funcName,
            @JsonProperty("tests") List<Test> tests
            ) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.funcName = funcName;
        this.tests = tests;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getJsScript() {
        return this.jsScript;
    }

    public String getFuncName() {
        return this.funcName;
    }

    public List<Test> getTests() {
        return this.tests;
    }

}
