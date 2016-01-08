package com.gateside.autotesting.generation.unittest;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.gateside.autotesting.Gat.executor.CaseExecutor;
import com.gateside.autotesting.Gat.executor.InterfaceSingleStepExecutor;
import com.gateside.autotesting.Gat.executor.InterfaceStepsExecutor;

public class IndexLogin3000001TestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void Login_success() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("IndexLogin3000001TestCase.xml","TestloginOk");
		executor.execute();
	}
	
	@Test
	public void Login_error() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("IndexLogin3000001TestCase.xml","TestloginErr");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

