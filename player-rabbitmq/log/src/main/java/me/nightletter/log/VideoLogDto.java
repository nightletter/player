package me.nightletter.log;

import java.io.Serializable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VideoLogDto implements Serializable {

	private Long videoId;
	private Long userId;
	private Integer playTime;
}
