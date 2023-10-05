package me.nightletter.video.controller;

import lombok.RequiredArgsConstructor;
import me.nightletter.video.domain.Video;
import me.nightletter.video.repository.VideoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping( "/player" )
@RequiredArgsConstructor
public class PlayerController {

	private final VideoRepository videoRepository;

	@GetMapping
	public String player( @RequestParam Long videoId, Model model ) {
		Video findVideo = videoRepository.findById( videoId )
			.orElseThrow( () -> new IllegalArgumentException() );

		model.addAttribute( "video", findVideo.getVideoId() );
		return "player";
	}
}
