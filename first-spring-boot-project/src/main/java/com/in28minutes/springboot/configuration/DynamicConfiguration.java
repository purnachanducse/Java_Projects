/**
 * 
 */
package com.in28minutes.springboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 10661300
 *
 */
@Component
@ConfigurationProperties("basic")
public class DynamicConfiguration {
	private boolean value;
	private String message;
	private int num;
	
	
	public boolean isValue() {
		return value;
	}


	public void setValue(boolean value) {
		this.value = value;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String toString() {
		return "DynamicConfiguration [value=" + value + ", message=" + message + ", num=" + num + "]";
	}
	
}
