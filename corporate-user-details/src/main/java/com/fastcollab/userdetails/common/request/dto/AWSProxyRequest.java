package com.fastcollab.userdetails.common.request.dto;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AWSProxyRequest {

	private String resource;
	private String path;
	private String methodArn;
	private String httpMethod;
	private Map<String, String> headers;
	private Map<String, Object> requestContext;
	private boolean isBase64Encoded;
	private String body;
}