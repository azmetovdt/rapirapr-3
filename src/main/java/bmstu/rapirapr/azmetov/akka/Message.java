package bmstu.rapirapr.azmetov.akka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Message {
    private final String packageId;
    private final String jsScript;
    private final String funcName;
    private final List<String> tests;

    @JsonCreator
    public Message(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("jsScript") String jsScript,
            @JsonProperty("funcName") String funcName,
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
