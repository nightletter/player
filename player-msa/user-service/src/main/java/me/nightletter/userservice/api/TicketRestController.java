package me.nightletter.userservice.api;

import lombok.RequiredArgsConstructor;
import me.nightletter.userservice.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ticket")
public class TicketRestController {

	private final TicketService ticketService;

	@PostMapping
	public ResponseEntity add( @RequestParam Long userId ) {
		ticketService.add( userId );
		return ResponseEntity.ok(  )
			.build();
	}
}
