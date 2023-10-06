package me.nightletter.logservice;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class UserResponse implements Serializable {

	private Long userId;
	private String userName;
	private boolean isTicket;
}
