package com.puente4podcast.puente4podcast.repositories;

import com.puente4podcast.puente4podcast.models.ComentaryEp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ComentaryEpRepository extends JpaRepository<ComentaryEp, Long> {
}