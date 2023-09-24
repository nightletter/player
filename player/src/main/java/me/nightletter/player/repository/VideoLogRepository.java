package me.nightletter.player.repository;

import me.nightletter.player.domain.Video;
import me.nightletter.player.domain.VideoLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoLogRepository extends JpaRepository<VideoLog, Long> {

}
