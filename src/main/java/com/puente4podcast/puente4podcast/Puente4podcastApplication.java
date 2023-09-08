package com.puente4podcast.puente4podcast;

import com.puente4podcast.puente4podcast.models.Episode;
import com.puente4podcast.puente4podcast.models.PodcastUser;
import com.puente4podcast.puente4podcast.repositories.EpisodeRepository;
import com.puente4podcast.puente4podcast.repositories.PodcastUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Puente4podcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(Puente4podcastApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PodcastUserRepository podcastUserRepository, EpisodeRepository episodeRepository) {
		return args -> {
			PodcastUser adminUser = new PodcastUser("admin", "admin", "admin", "admin@puente4podcast.com", "Chile", "admin");
			podcastUserRepository.save(adminUser);
			Episode episode1 = new Episode((byte) 1, (byte) 1, "Viajes en el tiempo, Nintendo y experimentos rusos", "https://i.ytimg.com/vi/HCZbEWn328U/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCW9N3Sq2ERk7rNJ6-ZD-koaGSlGg", "https://www.youtube.com/watch?v=HCZbEWn328U", "https://www.ivoox.com/1x01-cosas-como-viajes-tiempo-videojuegos-audios-mp3_rf_60420409_1.html", "1:31:13", "canon");
			Episode episode2 = new Episode((byte) 1, (byte) 2, "Pelis de libros, parásitos y expresiones", "https://i.ytimg.com/vi/X3ivw_LONtk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDVZJHcDl3BDHXQoHFhBiaZGsxBbQ", "https://www.youtube.com/watch?v=X3ivw_LONtk", "https://www.ivoox.com/1x03-cosas-como-pelis-libros-parasitos-y-audios-mp3_rf_61090555_1.html", "1:35:51", "canon");
			episodeRepository.save(episode1);
			episodeRepository.save(episode2);
		};
	}
}