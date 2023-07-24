package com.onlineshopping.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-reports/reports.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports/reports2.html",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/onlineshopping/step_definitions",
        dryRun = false,
        tags = ""
)
public class TestRunner {
}
