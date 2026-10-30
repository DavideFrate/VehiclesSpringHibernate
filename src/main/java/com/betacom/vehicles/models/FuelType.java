package com.betacom.vehicles.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "fuel_types")
public class FuelType extends Lookup {}
