package stepDefination;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(tags=" ",features= {"src/test/resources/features"},glue= {"stepDefination"},plugin= {"pretty",
		"html:target/htmlreport.html"
})
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
