package me.nightletter.videoservice;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class VideoResponse implements Serializable {

	private Long videoId;
	private String videoLink;

	public VideoResponse( Video video) {
		this.videoId = video.getVideoId();
		this.videoLink = video.getLink();
	}
}
