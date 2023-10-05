package me.nightletter.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.nightletter.log.service.VideoLogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMqListener {

	private final VideoLogService videoLogService;

	@RabbitListener(queues = "sample.queue")
	public void receiveMessage(VideoLogDto videoLogDto) {
		videoLogService.saveVideoLog( videoLogDto.getVideoId(), videoLogDto.getUserId(), videoLogDto.getPlayTime() );
	}
}
