package tdd.step.by.step.bdd;

import org.junit.runner.*;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 plugin = {"pretty", "html:target/cucumber-html-report"},
                 glue = "tdd.step.by.step.bdd.stepdefs")
public class RunCucumberTest {
}
