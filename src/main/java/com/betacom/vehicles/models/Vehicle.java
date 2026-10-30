package com.betacom.vehicles.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.JOINED)		// parent table and one table per child with the same id
public abstract class Vehicle {
	
}
