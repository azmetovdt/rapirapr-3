package bmstu.rapirapr.azmetov.akka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Test {

    private final String TEST_NAME_ALIAS = "testName";
    private final String EXPECTED_RESULT_ALIAS = "expectedResult";
    private final String PARAMS_ALIAS = "params";

    private final String testName;
    private final String expectedResult;
    private final List<Integer> params;

    @JsonCreator
    public Test(
            @JsonProperty(TEST_NAME_ALIAS) String testName,
            @JsonProperty(EXPECTED_RESULT_ALIAS) String expectedResult,
            @JsonProperty(PARAMS_ALIAS) List<Integer> params
    ) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }


    public String getTestName() {
        return this.testName;
    }

    public String getExpectedResult() {
        return this.expectedResult;
    }

    public List<Integer> getParams() {
        return this.params;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testName='" + testName + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                ", params=" + params +
                '}';
    }
}
