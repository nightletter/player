package me.nightletter.logservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LogService {

    private final LogRepository logRepository;
    private final WebClient.Builder webClientBuilder;

    public String begin(Long userId, Long videoId) {

        UserResponse findUser = webClientBuilder.build().get()
                .uri("http://user-service/api/users/" + userId)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();

        VideoResponse findVideo = webClientBuilder.build().get()
                .uri("http://video-service/api/video/" + videoId)
                .retrieve()
                .bodyToMono(VideoResponse.class)
                .block();

        log.info(findUser.getUserId().toString());
        log.info(findVideo.getVideoId().toString());

        try {
            logRepository.save(Log.begin(userId, videoId));
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }

        return "saved log";
    }

    public void play(Long userId, Long videoId, Integer playTime) {
        UserResponse findUser = webClientBuilder.build().get()
                .uri("http://user-service/api/users/" + userId)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();

        VideoResponse findVideo = webClientBuilder.build().get()
                .uri("http://video-service/api/video/" + videoId)
                .retrieve()
                .bodyToMono(VideoResponse.class)
                .block();

        logRepository.save(Log.play(findUser.getUserId(), findVideo.getVideoId(), playTime));
    }
}
