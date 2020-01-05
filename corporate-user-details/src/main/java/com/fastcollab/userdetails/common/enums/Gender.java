package com.fastcollab.userdetails.common.enums;

public enum Gender {
	MALE, FEMALE, TRANSGENDER;

	public static Gender getGender(String gender) {
		switch (gender) {
		case "1":
			return MALE;
		case "2":
			return FEMALE;
		default:
			return TRANSGENDER;
		}

	}

	public static Gender getGender(int gender) {
		switch (gender) {
		case 1:
			return MALE;
		case 2:
			return FEMALE;
		default:
			return TRANSGENDER;
		}

	}
}
