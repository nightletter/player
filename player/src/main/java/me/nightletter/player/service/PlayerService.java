package me.nightletter.player.service;

import lombok.RequiredArgsConstructor;
import me.nightletter.player.domain.Ticket;
import me.nightletter.player.domain.User;
import me.nightletter.player.domain.Video;
import me.nightletter.player.domain.VideoLog;
import me.nightletter.player.repository.TicketRepository;
import me.nightletter.player.repository.UserRepository;
import me.nightletter.player.repository.VideoLogRepository;
import me.nightletter.player.repository.VideoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

	private final UserRepository userRepository;
	private final VideoRepository videoRepository;
	private final VideoLogRepository videoLogRepository;
	private final TicketRepository ticketRepository;

	public Long begin(Long userId, Long videoId) {
		User findUser = getUser( userId );

		Ticket findTicket = ticketRepository.findByUserId( findUser.getUserId() )
			.orElseThrow( () -> new IllegalArgumentException() );

		Video findVideo = getVideo( videoId );

		VideoLog begin = VideoLog.begin( findVideo.getVideoId(), findUser.getUserId() );
		VideoLog savedVideoLog = videoLogRepository.save( begin );

		return savedVideoLog.getVideoLogId();
	}

	public Long playing(Long userId, Long videoId, Integer playTime) {
		User findUser = getUser( userId );
		Video findVideo = getVideo( videoId );

		VideoLog playing = VideoLog.playing( findVideo.getVideoId(), findUser.getUserId(), playTime );
		VideoLog savedVideoLog = videoLogRepository.save( playing );

		return savedVideoLog.getVideoLogId();
	}

	private User getUser( Long userId ) {
		User findUser = userRepository.findById( userId )
			.orElseThrow( () -> new IllegalArgumentException() );
		return findUser;
	}

	private Video getVideo( Long videoId ) {
		Video findVideo = videoRepository.findById( videoId )
			.orElseThrow( () -> new IllegalArgumentException() );
		return findVideo;
	}
}
