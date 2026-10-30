package com.betacom.vehicles.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "brand_types")
public class Brand extends Lookup {}
