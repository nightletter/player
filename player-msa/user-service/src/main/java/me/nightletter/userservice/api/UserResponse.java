package me.nightletter.userservice.api;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import me.nightletter.userservice.domain.Ticket;
import me.nightletter.userservice.domain.User;

@Getter
public class UserResponse implements Serializable {

	private Long userId;
	private String userName;
	private boolean isTicket;

	public UserResponse( User user ) {
		this.userId = user.getUserId();
		this.userName = user.getName();

		this.isTicket = false;

		if (user.getTickets().size() > 0) {
			this.isTicket = true;
		}
	}
}
