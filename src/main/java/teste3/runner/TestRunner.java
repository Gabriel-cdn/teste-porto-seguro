package teste3.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/teste3/features", glue = "teste3.steps", tags = "@cenario1")
public class TestRunner {
}