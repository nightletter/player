package me.nightletter.video.repository;

import java.util.Optional;
import me.nightletter.video.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("select t from Ticket t where t.user.userId =:userId")
	Optional<Ticket> findByUserId(Long userId);
}
