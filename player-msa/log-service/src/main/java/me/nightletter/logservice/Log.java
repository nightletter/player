package me.nightletter.logservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "TB_LOG")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;

	private Long userId;
	private Long videoId;
	private Integer playTime;

	@Builder
	public Log( Long logId, Long userId, Long videoId, Integer playTime ) {
		this.logId = logId;
		this.userId = userId;
		this.videoId = videoId;
		this.playTime = playTime;
	}

	public static Log begin(Long userId, Long videoId) {
		return Log.builder()
			.userId( userId )
			.videoId( videoId )
			.build();
	}

	public static Log play(Long userId, Long videoId, Integer playTime) {
		return Log.builder()
			.userId( userId )
			.videoId( videoId )
			.playTime( playTime )
			.build();
	}
}
