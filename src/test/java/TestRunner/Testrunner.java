package TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@runwith is a tag

@RunWith(Cucumber.class)

@CucumberOptions(
		
		//features={".//Features/LoginDDTExcel.feature"},
		features={".//Features/Login.feature"},
		glue="Stepdefinitions",
		
				plugin= {"pretty", "html:reports/myreport.html", 
						 "rerun:target/rerun.txt",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
						
				dryRun=false,    // checks mapping between scenario steps and step definition methods
				monochrome=true,    // to avoid junk characters in output
				publish=true,  // to publish report in cucumber server
	          tags="@regression"  // this will execute scenarios tagged with @sanity

		)



public class Testrunner {

}
