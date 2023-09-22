package com.puente4podcast.puente4podcast.repositories;
import com.puente4podcast.puente4podcast.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}