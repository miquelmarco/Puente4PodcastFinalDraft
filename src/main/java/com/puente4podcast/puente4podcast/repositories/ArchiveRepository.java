package com.puente4podcast.puente4podcast.repositories;

import com.puente4podcast.puente4podcast.models.Archive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {
}