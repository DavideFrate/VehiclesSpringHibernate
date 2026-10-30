package com.betacom.vehicles.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "colors")
public class Color extends Lookup {}
