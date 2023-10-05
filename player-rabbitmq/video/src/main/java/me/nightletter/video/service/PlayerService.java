package me.nightletter.video.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.nightletter.video.VideoLogDto;
import me.nightletter.video.domain.Ticket;
import me.nightletter.video.domain.User;
import me.nightletter.video.domain.Video;
import me.nightletter.video.repository.TicketRepository;
import me.nightletter.video.repository.UserRepository;
import me.nightletter.video.repository.VideoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

	private final UserRepository userRepository;
	private final VideoRepository videoRepository;
	private String EXCHANGE_NAME = "sample.exchange";
	private String ROUTING_KEY = "sample.routing.#";
	private final TicketRepository ticketRepository;
	private final RabbitTemplate rabbitTemplate;

	public void begin(Long userId, Long videoId) {
		User findUser = getUser( userId );

		Ticket findTicket = ticketRepository.findByUserId( findUser.getUserId() )
			.orElseThrow( () -> new IllegalArgumentException() );

		Video findVideo = getVideo( videoId );

		VideoLogDto videoLogDto = new VideoLogDto( findVideo.getVideoId(), findUser.getUserId() );
		log.info( "send begin" );
		rabbitTemplate.convertAndSend( EXCHANGE_NAME, ROUTING_KEY, videoLogDto );
	}

	public void playing(Long userId, Long videoId, Integer playTime) {
		User findUser = getUser( userId );

		Ticket findTicket = ticketRepository.findByUserId( findUser.getUserId() )
			.orElseThrow( () -> new IllegalArgumentException() );

		Video findVideo = getVideo( videoId );

		VideoLogDto videoLogDto = new VideoLogDto( findVideo.getVideoId(), findUser.getUserId(), playTime );
		log.info( "send play" );
		rabbitTemplate.convertAndSend( EXCHANGE_NAME, ROUTING_KEY, videoLogDto );
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
