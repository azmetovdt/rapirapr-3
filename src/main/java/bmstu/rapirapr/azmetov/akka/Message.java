package bmstu.rapirapr.azmetov.akka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Message {
    private static final String PACKAGE_ID_ALIAS = "packageId";
    private static final String JS_SCRIPT_ALIAS = "jsScript";
    private static  String FUNCTION_NAME_ALIAS = "functionName";
    private static final String TESTS_ALIAS = "tests";

    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final List<Test> tests;

    @JsonCreator
    public Message(
            @JsonProperty(PACKAGE_ID_ALIAS) String packageId,
            @JsonProperty(JS_SCRIPT_ALIAS) String jsScript,
            @JsonProperty(FUNCTION_NAME_ALIAS) String funcName,
            @JsonProperty(TESTS_ALIAS) List<Test> tests
    ) {
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
