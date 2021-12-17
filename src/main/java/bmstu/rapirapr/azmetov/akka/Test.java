package bmstu.rapirapr.azmetov.akka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Test {
    private final String testName;
    private final String expectedResult;
    private final List<Integer> params;

    @JsonCreator
    public Test(
            @JsonProperty("testName") String testName,
            @JsonProperty("expectedResult") String expectedResult,
            @JsonProperty("functionName") String funcName,
            @JsonProperty("tests") List<String> tests
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

    public List<String> getTests() {
        return this.tests;
    }

}
