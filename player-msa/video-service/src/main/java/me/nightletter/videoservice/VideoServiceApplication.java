package me.nightletter.videoservice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VideoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);
	}

	@Autowired
	VideoRepository videoRepository;

	@PostConstruct
	public void initialize() {
		Video video1 = new Video( "1" );
		videoRepository.save( video1 );

		Video video2 = new Video( "2" );
		videoRepository.save( video2 );
	}

}
