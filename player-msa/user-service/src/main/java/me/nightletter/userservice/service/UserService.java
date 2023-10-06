package me.nightletter.userservice.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import me.nightletter.userservice.api.UserResponse;
import me.nightletter.userservice.domain.User;
import me.nightletter.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void create(String name) {
		User savedUser = userRepository.save( new User( name ) );
	}

	@Transactional
	public UserResponse findById( Long userId ) {
		User findUser = userRepository.findById( userId )
			.orElseThrow( () -> new IllegalArgumentException() );

		return new UserResponse( findUser );
	}
}
