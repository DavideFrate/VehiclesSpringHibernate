package com.betacom.vehicles.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.vehicles.models.Messaggi;
import com.betacom.vehicles.models.MessaggiID;
import com.betacom.vehicles.repositories.IMessaggiRepository;
import com.betacom.vehicles.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessaggioImpl implements IMessaggioServices {
	
	private final IMessaggiRepository messageR;

	@Value("${lang}")
	private String lang;
	
	@Override
	public String get(String code) {
		log.debug(" get {}", code);
		String response = null;
		 
		Optional<Messaggi> messaggio = messageR.findById(new MessaggiID(lang, code));
		if (messaggio.isEmpty())
			response = code;
		else
			response = messaggio.get().getMessaggio();
		 
		return response;
	}
}
