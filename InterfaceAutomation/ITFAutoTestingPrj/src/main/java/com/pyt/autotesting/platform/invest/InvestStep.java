package com.pyt.autotesting.platform.invest;

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
public class InvestStep extends PytBaseTesting
{
	  
	 @StepMethodDesc(description="用户登录",owner="hexl")
	 public void userLogin(String parameterID) throws Exception
	 {
		 InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getInterfaceStepParameter(parameterID);
		 WebResponse response=super.getServiceResponse(parameter, super.domainWithLogin, super.httpMethodGet);
	     System.out.println(response.getText());
	     JSONObject resultObject=JSONObject.fromObject(response.getText());
	     String actualResult=(String)resultObject.get("FLAG");
	     Assert.assertTrue("Assert true exception", actualResult.contains("T"));
	 }
	 
	 @StepMethodDesc(description="投资前用户账户查询：",owner="hexl")
	 public void userAccountBefor(String parameterID) throws Exception
	 {
		 //测试用户查询接口
		 InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getInterfaceStepParameter(parameterID);
		 WebResponse response=super.getServiceResponse(parameter, super.domainWithService, super.httpMethodGet);
	     System.out.println(response.getText());
	     JSONObject resultObject=JSONObject.fromObject(response.getText());
	    // String s=(String)resultObject.get("useableamount");
	     //动态读取数据库内的数据
	     MysqlDBOperationService service=new MysqlDBOperationService(super.dbConnectingString);
	     List<List<String>> resultSet= service.executeQuery(parameter.getValue("UserInfoSql"),super.dbUser,super.dbPassword);
	     System.out.println("("+resultSet.get(1).get(0)+"),("+resultSet.get(1).get(1)+")");
	     StepValuePool.createInstance().getValueDic().put("doubiToken",response.getText());
	     //String actualResult=(String)resultObject.get("FLAG");
	    // Assert.assertTrue("Assert true exception", actualResult.contains("T"));
	     //StepValuePool.createInstance().getValueDic().put("doubiToken",response.getText());

			
	 }
	 //SERVERID=6180000&PRODUCT_ID=1681&INVEST_AMOUNT=1000&TRADE_PWD=pyt111111&PZTQ_INVEST_AMOUNT=0.00
	 @AssertStepMethodDesc(description="投资",owner="hexl")
	 public void investAction(String parameterID) throws Exception
	 {
		 InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getInterfaceStepParameter(parameterID);
		 WebResponse response=super.getServiceResponse(parameter, super.domainWithService, super.httpMethodPost);
		 System.out.println(response.getText());
	 }
	 @StepMethodDesc(description="账户比对",owner="hexl")
	 public void userAccountAfter(String parameterID) throws Exception
	 {
		 InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getInterfaceStepParameter(parameterID);
		 WebResponse response=super.getServiceResponse(parameter, super.domainWithService, super.httpMethodGet);
	     System.out.println(response.getText());
	     JSONObject resultObject=JSONObject.fromObject(response.getText());
	     
	     MysqlDBOperationService service=new MysqlDBOperationService(super.dbConnectingString);
	     List<List<String>> resultSet= service.executeQuery(parameter.getValue("UserInfoSql"),super.dbUser,super.dbPassword);
	  	
	 }
    
}
