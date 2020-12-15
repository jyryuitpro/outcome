package com.blackoperations.outcome.domain;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Reservation save(Reservation reservation);
}
