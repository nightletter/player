package me.nightletter.userservice.api;

import lombok.RequiredArgsConstructor;
import me.nightletter.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity createUser( @RequestParam String name ) {
		userService.create( name );
		return ResponseEntity.ok()
			.build();
	}

	@GetMapping("/{userId}")
	public ResponseEntity getUser( @PathVariable Long userId ) {
		UserResponse result = userService.findById( userId );
		return ResponseEntity.ok(result);
	}
}
