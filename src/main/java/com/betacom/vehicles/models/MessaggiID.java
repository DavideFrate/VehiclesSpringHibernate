package com.betacom.vehicles.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class MessaggiID implements Serializable {
	
	@Column (length = 4)
	private String lang;	// language code
	
	@Column (length = 20)
	private String code;	// message code
}
