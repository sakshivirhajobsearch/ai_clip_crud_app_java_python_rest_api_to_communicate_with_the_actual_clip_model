package ai.clip.crud.app.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ai.clip.crud.app.java.model.ClipData;

@Repository
public interface ClipRepository extends JpaRepository<ClipData, Long> {
}
