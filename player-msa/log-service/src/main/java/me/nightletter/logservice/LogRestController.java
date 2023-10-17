package me.nightletter.logservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
	@CircuitBreaker(name = "beginLog", fallbackMethod = "beginFallbackMethod")
    public ResponseEntity begin(@RequestParam Long userId,
                                @RequestParam Long videoId) {

        logService.begin(userId, videoId);

        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity beginFallbackMethod(Long userId, Long videoId, RuntimeException e) {
		return ResponseEntity.ok("Oops !! userId=" + userId + ", videoId=" + videoId);
    }

    @PostMapping("/play")
    public ResponseEntity begin(@RequestParam Long userId,
                                @RequestParam Long videoId,
                                @RequestParam Integer playTime) {

        logService.play(userId, videoId, playTime);

        return ResponseEntity.ok()
                .build();
    }
}
