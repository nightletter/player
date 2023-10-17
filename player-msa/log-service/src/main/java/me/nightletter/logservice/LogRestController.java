package me.nightletter.logservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/log")
public class LogRestController {

    private final LogService logService;

    @PostMapping("/begin")
	@CircuitBreaker(name = "beginLog", fallbackMethod = "beginFallbackMethod")
    @TimeLimiter(name = "beginLog")
    @Retry(name = "beginLog")
    public CompletableFuture begin(@RequestParam Long userId,
                                   @RequestParam Long videoId) {

        return CompletableFuture.supplyAsync(() -> logService.begin(userId, videoId));
    }

    public CompletableFuture beginFallbackMethod(Long userId, Long videoId, RuntimeException e) {
        return CompletableFuture.supplyAsync(() -> "Oops !! userId=" + userId + ", videoId=" + videoId);
    }

    @PostMapping("/play")
    @CircuitBreaker(name = "playLog", fallbackMethod = "playFallbackMethod")
    public ResponseEntity begin(@RequestParam Long userId,
                                @RequestParam Long videoId,
                                @RequestParam Integer playTime) {

        logService.play(userId, videoId, playTime);

        return ResponseEntity.ok()
                .build();
    }

    public ResponseEntity playFallbackMethod(Long userId, Long videoId, Integer playTime, RuntimeException e) {
        return ResponseEntity.ok("Oops !! userId=" + userId + ", videoId=" + videoId + ", playTime=" + playTime
        );
    }
}
