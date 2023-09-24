package me.nightletter.player.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "TB_VIDEO_LOG" )
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public class VideoLog {


	private enum VideoLogType {
		ENTRY, PLAYING
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "VIDEO_LOG_ID" )
	private Long videoLogId;

	private Long videoId;
	private Long userId;
	@Enumerated( value = EnumType.STRING )
	private VideoLogType type;

	private Integer playTime;

	@Builder
	public VideoLog( Long videoLogId, Long videoId, Long userId, VideoLogType type, Integer playTime ) {
		this.videoLogId = videoLogId;
		this.videoId = videoId;
		this.userId = userId;
		this.type = type;
		this.playTime = playTime;
	}

	public static VideoLog begin( Long videoId, Long userId ) {
		return VideoLog.builder()
			.videoId( videoId )
			.userId( userId )
			.type(VideoLogType.ENTRY)
			.playTime( 0 )
			.build();
	}

	public static VideoLog playing( Long videoId, Long userId, Integer playTime ) {
		return VideoLog.builder()
			.videoId( videoId )
			.userId( userId )
			.type(VideoLogType.PLAYING)
			.playTime( playTime )
			.build();
	}
}
