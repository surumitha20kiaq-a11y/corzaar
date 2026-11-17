package test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import base.BaseClass;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
		features="src\\test\\java\\Feature\\corzaar.feature",
      glue="step",
      dryRun=false,
      monochrome=true,
      
      plugin = {
    		  "pretty",
    		  
    		  "html:target/CucumberReport.html",
    		   
    		  "json:target/Cucumber.json",
    		   
    		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
  )  

public class TestRunner extends AbstractTestNGCucumberTests{
	BaseClass base = new BaseClass();

	@BeforeClass
	public  void Startup() {
	base.ChromebrowserLaunch();
	base.maximizeWindow();
	
	}
	 
   @AfterClass
  	public void end() {
	 base.quitchrome();
	}

}


