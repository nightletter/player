package me.nightletter.video.controller;

import lombok.RequiredArgsConstructor;
import me.nightletter.video.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/player" )
@RequiredArgsConstructor
public class PlayerRestController {

	private final PlayerService playerService;

	@PostMapping( "/begin/{videoId}" )
	public ResponseEntity begin( @PathVariable Long videoId,
	                             @CookieValue Long userId ) {

		playerService.begin( userId, videoId );

		return ResponseEntity.ok()
			.build();
	}

	@PostMapping( "/play/{videoId}" )
	public ResponseEntity play( @PathVariable Long videoId,
	                            @CookieValue Long userId,
	                            @RequestParam Integer playTime ) {

		playerService.playing( userId, videoId, playTime );
		return ResponseEntity.ok()
			.build();
	}
}
