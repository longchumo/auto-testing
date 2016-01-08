package com.pyt.autotesting.platform.index;

import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Assert;

import com.gateside.autotesting.Gat.dataobject.AssertStepMethodDesc;
import com.gateside.autotesting.Gat.dataobject.StepMethodDesc;
import com.gateside.autotesting.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.gateside.autotesting.Gat.util.ParameterHelper;
import com.gateside.autotesting.Gat.util.StepValuePool;
import com.gateside.autotesting.Lib.dbService.MysqlDBOperationService;
import com.meterware.httpunit.WebResponse;
import com.pyt.autotesting.common.util.PytBaseTesting;
public class LoginTest extends PytBaseTesting
{
	  
	 @StepMethodDesc(description="用户登录",owner="hexl")
	 public void loginOk(String parameterID) throws Exception
	 {
		 InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getInterfaceStepParameter(parameterID);
		 WebResponse response=super.getServiceResponse(parameter, super.domainWithLogin, super.httpMethodGet);
	     System.out.println(response.getText());
	     JSONObject resultObject=JSONObject.fromObject(response.getText());
	     String actualResult=(String)resultObject.get("FLAG");
	     Assert.assertTrue("Assert true exception", actualResult.contains("T"));
	 }
	 
	 @StepMethodDesc(description="用户登录",owner="hexl")
	 public void loginErr(String parameterID) throws Exception
	 {
		 InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getInterfaceStepParameter(parameterID);
		 WebResponse response=super.getServiceResponse(parameter, super.domainWithLogin, super.httpMethodGet);
	     System.out.println(response.getText());
	     JSONObject resultObject=JSONObject.fromObject(response.getText());
	     String actualResult=(String)resultObject.get("FLAG");
	     Assert.assertTrue("Assert true exception", actualResult.contains("F"));
	 }
	 
    
}
