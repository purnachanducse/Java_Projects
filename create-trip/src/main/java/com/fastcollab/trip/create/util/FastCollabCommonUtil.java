package com.fastcollab.trip.create.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.util.DigestUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
 * 
 * @author FastCollab
 *
 */
public class FastCollabCommonUtil {

	private FastCollabCommonUtil() {
	}

	public static final String API_DATE = "ddMMyy";// response date format from
													// soap end point
	public static final String API_TIME = "HHmm";// response time format from
													// soap end point
	public static final String REQUEST_DATE = "dd-MM-yyyy";// request date
															// format from
															// client
	public static final String END_POINT_API_DATE_TIME = "ddMMyy HHmm";// combining
																		// above
																		// two
																		// fields
	public static final String API_DATE_TIME = "yyyy-MM-dd HH:mm";// required
																	// format
																	// for
																	// client

	public static ObjectMapper mapper = null;

	static {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	}

	/**
	 * 
	 * @param <T>
	 * @param body
	 * @param clazz
	 * @return (Request Body<T>) clazz
	 * @throws IOException
	 */
	public static <T> T getRequestBoby(String body, Class<T> clazz) throws Exception {
		return mapper.readValue(body, clazz);
	}

	/**
	 * 
	 * @param <T>
	 * @param body
	 * @return String
	 */
	public static <T> String getResponseBody(T body) {
		try {
			return mapper.writeValueAsString(body);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param value
	 * @return true if value is not empty else false
	 */
	public static boolean isStringNotEmpty(String value) {
		return value != null && !value.trim().isEmpty();
	}

	/**
	 * @param strDateTime
	 * @param fromFormat
	 * @param toDateFormat
	 * @return returns the date time by taking the input format with output
	 *         format
	 */
	public static String changeDateTimeStringFormate(String strDateTime, String fromFormat, String toDateFormat) {
		if (!isStringNotEmpty(strDateTime) || !isStringNotEmpty(fromFormat) || !isStringNotEmpty(toDateFormat)) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fromFormat);
		LocalDateTime ldt = LocalDateTime.parse(strDateTime, formatter);
		return DateTimeFormatter.ofPattern(toDateFormat).format(ldt);

	}

	/**
	 *
	 * @param strDateTime
	 * @param fromFormat
	 * @param toDateFormat
	 * @return returns the date by taking the input format with output format
	 */
	public static String changeDateStringFormate(String strDateTime, String fromFormat, String toDateFormat) {
		if (!isStringNotEmpty(strDateTime) || !isStringNotEmpty(fromFormat) || !isStringNotEmpty(toDateFormat)) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fromFormat);
		LocalDate ldt = LocalDate.parse(strDateTime, formatter);
		return DateTimeFormatter.ofPattern(toDateFormat).format(ldt);

	}

	/**
	 * returns the date & time to required format
	 * 
	 * @param dateTime
	 * @param format
	 * @return
	 */
	public static LocalDateTime toParseLocalDateTime(String dateTime, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDateTime.parse(dateTime, formatter);
	}

	/**
	 * @return generated random UUID with time stamp
	 * @throws Exception
	 */
	public static String generateRandomKey() {
		String ts = String.valueOf(System.currentTimeMillis());
		String rand = UUID.randomUUID().toString();
		return DigestUtils.md5DigestAsHex((ts + rand).getBytes());

	}
}
