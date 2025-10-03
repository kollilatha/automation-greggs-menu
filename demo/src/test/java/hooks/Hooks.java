package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reports.utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

// If you are unsure, search your project for 'ExtentManager.java' and use its package declaration here.

public class Hooks {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().fail("Scenario Failed");
        } else {
            test.get().pass("Scenario Passed");
        }
        extent.flush(); // save the report
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}
