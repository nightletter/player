package me.nightletter.videoservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "TB_VIDEO" )
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public class Video {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long videoId;
	private String link;

	public Video( String link ) {
		this.link = link;
	}
}
