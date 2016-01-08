package com.gateside.autotesting.generation.unittest;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.gateside.autotesting.Gat.executor.CaseExecutor;
import com.gateside.autotesting.Gat.executor.InterfaceSingleStepExecutor;
import com.gateside.autotesting.Gat.executor.InterfaceStepsExecutor;

public class Invest6180000TestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void RegisterGameUser_success() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("Invest6180000TestCase.xml","TestCase01");
		executor.execute();
	}
	
	@Test
	public void RegisterGameUser_success2() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("Invest6180000TestCase.xml","TestCase02");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

