package com.betacom.vehicles.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.betacom.vehicles.dto.output.ResponseDTO;
import com.betacom.vehicles.exceptions.VehicleException;
import com.betacom.vehicles.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionManager {
	
	private final IMessaggioServices messageS;
	
	// Catch all exceptions and print their message
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handlerException(Exception e) {
		return ResponseEntity.badRequest()
							 .body(ResponseDTO.builder()
									 		  .message(messageS.get(e.getMessage()))
									 		  .build());
	}
	
	// Validation handler
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerValidationException(MethodArgumentNotValidException e) {
		
		String msg = e.getBindingResult()
					  .getFieldErrors()
					  .stream()
					  .findFirst()
					  .map(FieldError::getDefaultMessage)
					  .orElse("Errore di validazione");
		
		return ResponseEntity.badRequest()
							 .body(ResponseDTO.builder()
									 		  .message(messageS.get(msg))
									 		  .build());
				
	}
	
	@ExceptionHandler(VehicleException.class)
	public ResponseEntity<ResponseDTO> handleAcademy(VehicleException e) {
		String msg = messageS.get(e.getMessage());
		if (e.getDetail() != null)
			msg += " " + e.getDetail();
		
		return ResponseEntity.badRequest()
							 .body(ResponseDTO.builder()
									 		  .message(msg)
									 		  .build());
	}
}
