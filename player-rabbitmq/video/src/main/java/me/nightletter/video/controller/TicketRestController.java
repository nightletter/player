package me.nightletter.video.controller;

import lombok.RequiredArgsConstructor;
import me.nightletter.video.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/ticket" )
@RequiredArgsConstructor
public class TicketRestController {

	private final TicketService ticketService;

	@PostMapping
	public ResponseEntity addTicket( @CookieValue Long userId ) {
		ticketService.addTicket( userId );
		return ResponseEntity.ok()
			.build();
	}
}
