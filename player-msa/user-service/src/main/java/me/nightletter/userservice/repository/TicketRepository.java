package me.nightletter.userservice.repository;

import me.nightletter.userservice.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
