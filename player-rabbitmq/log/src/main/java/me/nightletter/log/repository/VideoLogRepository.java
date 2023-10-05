package me.nightletter.log.repository;

import me.nightletter.log.domain.VideoLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoLogRepository extends JpaRepository<VideoLog, Long> {

}
