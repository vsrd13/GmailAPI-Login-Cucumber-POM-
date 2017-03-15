package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

/**
 * Created by Kumar on 2/11/2017.
 */

//@RunWith(Cucumber.class) -- JUnit
@CucumberOptions(features = {"src/test/java/features"},
        format = {"html:target/site/cucumber-pretty", "json:target/cucumber.json"},glue = "steps")
public class TestRunner extends AbstractTestNGCucumberTests{
}

//format = {"pretty", "html:target/cucumber-html-report", "pretty:target/cucumber-report.json"}
