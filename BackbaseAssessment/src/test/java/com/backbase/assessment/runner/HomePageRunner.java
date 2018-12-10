
package com.backbase.assessment.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" },
                 features="src/test/resources/features",
                 glue="com.backbase.assessment",
                 tags={"@SearchComputer"})
public class HomePageRunner {

}
