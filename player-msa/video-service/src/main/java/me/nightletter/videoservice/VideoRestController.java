package me.nightletter.videoservice;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/video" )
@RequiredArgsConstructor
public class VideoRestController {

	private final VideoRepository videoRepository;

	@GetMapping
	public ResponseEntity<List<VideoResponse>> findVideoList() {

		List<Video> findVideos = videoRepository.findAll();

		List<VideoResponse> result = findVideos.stream()
			.map( VideoResponse::new )
			.collect( Collectors.toList() );

		return ResponseEntity.ok( result );
	}

	@GetMapping( "/{videoId}" )
	public ResponseEntity<VideoResponse> findVideo( @PathVariable Long videoId ) {

		Video findVideo = videoRepository.findById( videoId )
			.orElseThrow( () -> new IllegalArgumentException() );

		return ResponseEntity.ok( new VideoResponse( findVideo ) );
	}
}
