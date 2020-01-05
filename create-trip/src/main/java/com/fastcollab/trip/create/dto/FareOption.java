package com.fastcollab.trip.create.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FareOption implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -89862078923095157L;

	private String fareKey;
	private String apiType;
	private String traceId;
	private String resultIndex;
	private boolean refundable;
	private String providerType;
	private Integer fareType;//Flight_options.Frae_Type
	private String airlineRemark;
	private Fare fare;
	private List<PaxFare> paxFares = new ArrayList<>();
	private List<Cancellation> cancellation = new ArrayList<>();
	private List<FareRuleInfos> fareRuleInfos = new ArrayList<>();
}
