package me.nightletter.player.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "TB_TICKET" )
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public class Ticket {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long ticketId;
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "USER_ID" )
	private User user;

	public Ticket( User user) {
		this.user = user;
	}
}
