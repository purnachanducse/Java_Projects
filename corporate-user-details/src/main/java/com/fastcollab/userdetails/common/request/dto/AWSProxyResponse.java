package com.fastcollab.userdetails.common.request.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fastcollab.userdetails.common.enums.FCHttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class AWSProxyResponse  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4108012477546036422L;
	
	
	private boolean isBase64Encoded;
	private int statusCode;
	private Map<String,Object> headers = new HashMap<>();
	private String body;
    
    private AWSProxyResponse() {
    }

	public AWSProxyResponse(Object payload, String message, FCHttpStatus status){
		FastcollabResponse fastcollabResponse = new FastcollabResponse(payload,message,status);
		this.body = FastCollabCommonUtil.getResponseBody(fastcollabResponse);
		this.statusCode = fastcollabResponse.getStatus().getCode();
	}

	public AWSProxyResponse(String message,FCHttpStatus status){
		FastcollabResponse fastcollabResponse = new FastcollabResponse(message,status);
		this.body = FastCollabCommonUtil.getResponseBody(fastcollabResponse);
		this.statusCode = fastcollabResponse.getStatus().getCode();
	}

	public AWSProxyResponse(Object payload,FCHttpStatus status){
		FastcollabResponse fastcollabResponse = new FastcollabResponse(payload,status);
		this.body = FastCollabCommonUtil.getResponseBody(fastcollabResponse);
		this.statusCode = fastcollabResponse.getStatus().getCode();
	}

	public AWSProxyResponse(Object payload,boolean isBase64Encoded,FCHttpStatus status){
		FastcollabResponse fastcollabResponse = new FastcollabResponse(payload,status);
		this.body = FastCollabCommonUtil.getResponseBody(fastcollabResponse);
		this.statusCode = fastcollabResponse.getStatus().getCode();
		this.isBase64Encoded = isBase64Encoded;
	}

	public AWSProxyResponse(Object payload,boolean isBase64Encoded,String message,FCHttpStatus status){
		FastcollabResponse fastcollabResponse = new FastcollabResponse(payload,message,status);
		this.body = FastCollabCommonUtil.getResponseBody(fastcollabResponse);
		this.statusCode = fastcollabResponse.getStatus().getCode();
		this.isBase64Encoded = isBase64Encoded;
	}
}
