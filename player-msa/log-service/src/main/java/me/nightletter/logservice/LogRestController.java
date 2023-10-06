package me.nightletter.logservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/log")
public class LogRestController {

	private final LogService logService;

	@PostMapping("/begin")
	public ResponseEntity begin( @RequestParam Long userId,
	                             @RequestParam Long videoId) {

		logService.begin( userId, videoId );

		return ResponseEntity.ok()
			.build();
	}

	@PostMapping("/play")
	public ResponseEntity begin( @RequestParam Long userId,
	                             @RequestParam Long videoId,
	                             @RequestParam Integer playTime) {

		logService.play( userId, videoId, playTime );

		return ResponseEntity.ok()
			.build();
	}
}
