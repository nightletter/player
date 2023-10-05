package me.nightletter.video.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id
	private Long userId;

	private String name;

	@OneToMany
	private List<Ticket> tickets;

	public User( Long userId, String name ) {
		this.userId = userId;
		this.name = name;
	}
}
