package com.betacom.vehicles.exceptions;

import lombok.Getter;

@Getter
public class VehicleException extends RuntimeException {
	
	private final String detail;
	
	public VehicleException() {
		this(null, null);
	}
	
	public VehicleException(String code) {
		this(code, null);
	}
	
	public VehicleException(String code, String detail) {
		super(code);
		this.detail = detail;
	}
}
