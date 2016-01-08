package com.pyt.autotesting.common.util;

import java.util.HashMap;

import com.gateside.autotesting.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.gateside.autotesting.Lib.common.ConfigReader;
import com.gateside.autotesting.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public abstract class PytBaseTesting {
	
	public String domainWithLogin="/login.html";
	public String domainWithService="/service.html";
	public String httpMethodPost="POST";
	public String httpMethodGet="GET";
	public String dbConnectingString="";
	public String dbUser="";
	public String dbPassword="";
	
	public PytBaseTesting(){
		String domainName=ConfigReader.GetValue("pytConfig.properties","DomainName");
		domainWithLogin=domainName+domainWithLogin;
		domainWithService=domainName+domainWithService;
		dbConnectingString=ConfigReader.GetValue("pytConfig.properties","DbConnectString");
		dbUser=ConfigReader.GetValue("pytConfig.properties","DbUser");
		dbPassword=ConfigReader.GetValue("pytConfig.properties","DbPassword");		
	}
	
	public WebResponse getServiceResponse(InterfaceStepParameter parameter,String DomainName,String httpMethod) throws Exception{
				
		WebConversation currentConversation=HttpUnitHelper.createConversation();
	    WebRequest currentRequest=HttpUnitHelper.createWebRequest(DomainName,httpMethod);
	    HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    if(urlParameters.size()!=0){
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);
	    }
	    WebResponse response=currentConversation.getResponse(currentRequest);	
	    return response;
	}
	
}