package me.nightletter.log.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "VIDEO_LOG_ID" )
	private Long videoLogId;

	private Long videoId;
	private Long userId;
	private Integer playTime;

	@Builder
	public VideoLog( Long videoLogId, Long videoId, Long userId, Integer playTime ) {
		this.videoLogId = videoLogId;
		this.videoId = videoId;
		this.userId = userId;
		this.playTime = playTime;
	}

	public static VideoLog create( Long videoId, Long userId, Integer playTime ) {
		return VideoLog.builder()
			.videoId( videoId )
			.userId( userId )
			.playTime( playTime )
			.build();
	}
}
