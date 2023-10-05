package me.nightletter.log.service;

import lombok.RequiredArgsConstructor;
import me.nightletter.log.domain.VideoLog;
import me.nightletter.log.repository.VideoLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VideoLogService {

	private final VideoLogRepository videoLogRepository;

	@Transactional
	public void saveVideoLog( Long videoId, Long userId, Integer playTime ) {
		VideoLog created = VideoLog.create( videoId, userId, playTime);
		videoLogRepository.save( created );
	}
}
