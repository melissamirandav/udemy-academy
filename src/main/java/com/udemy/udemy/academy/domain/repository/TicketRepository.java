package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.TicketEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity, UUID> {

}
