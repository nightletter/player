package me.nightletter.video;

import jakarta.annotation.PostConstruct;
import me.nightletter.video.domain.User;
import me.nightletter.video.domain.Video;
import me.nightletter.video.repository.UserRepository;
import me.nightletter.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}

	@Autowired
	VideoRepository videoRepository;

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void initSampleData() {
		User user = new User( 1L, "user1" );
		userRepository.save( user );

		Video video = new Video( 1L, "http://localhost:8080" );
		videoRepository.save( video );
	}
}
