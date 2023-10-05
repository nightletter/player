package me.nightletter.video;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class VideoLogDto implements Serializable {

	private Long videoId;
	private Long userId;
	private Integer playTime = 0;

	public VideoLogDto( Long videoId, Long userId ) {
		this.videoId = videoId;
		this.userId = userId;
	}

	public VideoLogDto( Long videoId, Long userId, Integer playTime ) {
		this.videoId = videoId;
		this.userId = userId;
		this.playTime = playTime;
	}
}
