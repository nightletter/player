package me.nightletter.player.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import me.nightletter.player.domain.Ticket;
import me.nightletter.player.domain.User;
import me.nightletter.player.repository.TicketRepository;
import me.nightletter.player.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService {

	private final UserRepository userRepository;

	private final TicketRepository ticketRepository;

	public void addTicket(Long userId) {
		User findUser = userRepository.findById( userId )
			.orElseThrow( () -> new IllegalArgumentException() );

		Optional<Ticket> findTicket = ticketRepository.findByUserId( userId );
		if (findTicket.isPresent()) {
			throw new RuntimeException("사용중인 이용권이 존재합니다.");
		}

		ticketRepository.save( new Ticket( findUser ) );
	}
}
