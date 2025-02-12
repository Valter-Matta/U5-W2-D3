package com.gestione.blogging.autori;

import com.gestione.blogging.response.GeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/autore")
@RequiredArgsConstructor
public class AutoreController {
	private final AutoreService autoreService;

	@GetMapping
	@ResponseStatus (HttpStatus.OK)
	public List<Autore> findAll () {
		return autoreService.findAll();
	}

	@GetMapping("/{id}")
	public Autore findById (@PathVariable Long id) {
		return autoreService.findById(id);
	}

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public GeneralResponse create (@RequestBody AutoreRequest request) {
		return autoreService.save(request);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete (Long id) {
		autoreService.delete(id);
	}
}
