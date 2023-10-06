package me.nightletter.logservice;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class VideoResponse implements Serializable {

	private Long videoId;
	private String videoLink;
}
