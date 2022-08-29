package com.bridgelabz.utility;

public class Response {

    private	String responseStutus;
    private int resposeCode;
    private Object responseData;
    
	public String getResponseStutus() {
		return responseStutus;
	}
	public void setResponseStutus(String responseStutus) {
		this.responseStutus = responseStutus;
	}
	public int getResposeCode() {
		return resposeCode;
	}
	public void setResposeCode(int resposeCode) {
		this.resposeCode = resposeCode;
	}
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	public Response(String responseStutus, int resposeCode, Object responseData) {
		
		this.responseStutus = responseStutus;
		this.resposeCode = resposeCode;
		this.responseData = responseData;
	}
    
    
}
