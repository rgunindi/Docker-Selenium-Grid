package Proje;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-report/cucumber.html", "timeline:target/cucumber-report/"},
        features = "classpath:features",
        monochrome = true
)
public class CucumberTestSuite {}


