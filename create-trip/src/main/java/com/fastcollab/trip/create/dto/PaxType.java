package com.fastcollab.trip.create.dto;

public enum PaxType {
	ADT, // Adult
	CH,
	CHD, // Child
	INF, // Infant
	INS, // Infant with a seat
	UNN; // unaccompanied child

	public static PaxType getPaxType(String paxType) {
		switch (paxType) {
		case "ADT":
			return ADT;
		case "CHD":
		case "CH":
			return CHD;
		case "INF":
			return INF;
		case "INS":
			return INS;
		default:
			return UNN;
		}

	}
	
	public static PaxType getPaxType(Integer paxType) {
		switch (paxType) {
		case 1:
			return ADT;
		case 2:
			return CHD;
		case 3:
			return INF;
		case 4:
			return INS;
		default:
			return UNN;
		}

	}
}
