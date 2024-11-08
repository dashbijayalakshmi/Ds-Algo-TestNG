package Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNgRunner {

	public static void main(String[] args) 
	{
		//Created an object of TestNG
		TestNG objTNG = new TestNG();
		
		//Define a list 
		List<String> suites = new ArrayList<String>();
		
		//Add the TestNG.xml files
		suites.add("/Users/nehapatni/eclipse-workspace/Ds-Algo-TestNG/testng.xml");
		
		//Set the suites to run 
		objTNG.setTestSuites(suites);
		
		
		//Call the run method
		objTNG.run();
		
		
	}

}
