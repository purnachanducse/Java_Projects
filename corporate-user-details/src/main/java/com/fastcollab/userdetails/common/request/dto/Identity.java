package com.fastcollab.userdetails.common.request.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Identity {
	 private String cognitoIdentityPoolId = null;
	 private String accountId = null;
	 private String cognitoIdentityId = null;
	 private String caller = null;
	 private String sourceIp;
	 private String principalOrgId = null;
	 private String accessKey = null;
	 private String cognitoAuthenticationType = null;
	 private String cognitoAuthenticationProvider = null;
	 private String userArn = null;
	 private String userAgent;
	 private String user = null;


	}
