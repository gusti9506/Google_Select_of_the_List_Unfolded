package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                //"me.jvt.cucumber.report.PrettyReports:target/Cucumber-Reportes[HTML]",
                "json:target/Reports-Cucumber.json"
                },
        monochrome = true,
        glue = "steps",
        tags = "@Test1"
)


public class Runner {
    @AfterClass
    public static void quitDriver() {
        BasePage.closeDriver();
    }
}
