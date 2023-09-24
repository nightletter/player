package me.nightletter.player;

import me.nightletter.player.domain.User;
import me.nightletter.player.domain.Video;
import me.nightletter.player.repository.UserRepository;
import me.nightletter.player.repository.VideoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class PlayerApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	VideoRepository videoRepository;

	@Transactional
	@Rollback(value = false)
	void initUser() {
		User user = new User( 1L, "user1" );
		userRepository.save( user );
	}

	@Transactional
	@Rollback(value = false)
	void initVideo() {
		Video video = new Video( 1L, "http://localhost:8080" );
		videoRepository.save( video );
	}
}
