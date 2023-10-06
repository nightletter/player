package me.nightletter.userservice.service;

import lombok.RequiredArgsConstructor;
import me.nightletter.userservice.domain.Ticket;
import me.nightletter.userservice.domain.User;
import me.nightletter.userservice.repository.TicketRepository;
import me.nightletter.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketService {

	private final UserRepository userRepository;
	private final TicketRepository ticketRepository;

	@Transactional
	public void add(Long userId) {
		User findUser = userRepository.findById( userId )
			.orElseThrow( () -> new IllegalArgumentException() );

		Ticket savedTicket = ticketRepository.save( new Ticket( findUser ) );
	}
}
