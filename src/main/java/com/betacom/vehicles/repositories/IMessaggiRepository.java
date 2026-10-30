package com.betacom.vehicles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.vehicles.models.Messaggi;
import com.betacom.vehicles.models.MessaggiID;

public interface IMessaggiRepository extends JpaRepository<Messaggi, MessaggiID> {

}
