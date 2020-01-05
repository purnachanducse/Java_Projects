package com.fastcollab.userdetails.common.request.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestContext {
	 private String resourceId;
	 private String resourcePath;
	 private String httpMethod;
	 private String extendedRequestId;
	 private String requestTime;
	 private String path;
	 private String accountId;
	 private String protocol;
	 private String stage;
	 private String domainPrefix;
	 private float requestTimeEpoch;
	 private String requestId;
	 Identity IdentityObject;
	 private String domainName;
	 private String apiId;
	}
