package Proje;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features",
        monochrome = true
        //,dryRun = true
)
public class CucumberTestSuite {}


