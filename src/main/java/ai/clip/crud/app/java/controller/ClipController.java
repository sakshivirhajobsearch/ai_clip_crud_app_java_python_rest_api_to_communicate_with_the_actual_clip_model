package ai.clip.crud.app.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.clip.crud.app.java.model.ClipData;
import ai.clip.crud.app.java.service.ClipService;

@RestController
@RequestMapping("/api/clips")
public class ClipController {
	@Autowired
	private ClipService service;

	@PostMapping
	public ClipData create(@RequestBody ClipData clip) {
		return service.create(clip);
	}

	@GetMapping
	public List<ClipData> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ClipData getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@PutMapping("/{id}")
	public ClipData update(@PathVariable Long id, @RequestBody ClipData clip) {
		return service.update(id, clip);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
