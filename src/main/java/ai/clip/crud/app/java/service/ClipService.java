package ai.clip.crud.app.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.clip.crud.app.java.model.ClipData;
import ai.clip.crud.app.java.repository.ClipRepository;

@Service
public class ClipService {
	@Autowired
	private ClipRepository repository;

	public List<ClipData> getAll() {
		return repository.findAll();
	}

	public ClipData getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public ClipData create(ClipData clip) {
		return repository.save(clip);
	}

	public ClipData update(Long id, ClipData updated) {
		ClipData existing = getById(id);
		if (existing == null)
			return null;
		existing.setImagePath(updated.getImagePath());
		existing.setDescription(updated.getDescription());
		return repository.save(existing);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
