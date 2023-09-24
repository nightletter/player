package me.nightletter.player.controller;

import lombok.RequiredArgsConstructor;
import me.nightletter.player.repository.VideoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class VideoController {
	private final VideoRepository videoRepository;

	@GetMapping
	public String videoList( Model model ) {
		model.addAttribute( "videos", videoRepository.findAll() );
		return "videoList";
	}
}
