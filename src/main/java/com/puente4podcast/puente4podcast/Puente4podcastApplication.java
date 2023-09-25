package com.puente4podcast.puente4podcast;
import com.puente4podcast.puente4podcast.models.*;
import com.puente4podcast.puente4podcast.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
@SpringBootApplication
public class Puente4podcastApplication {
	public static void main(String[] args) {
		SpringApplication.run(Puente4podcastApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PodcastUserRepository podcastUserRepository, PodcastRepository podcastRepository, SeasonRepository seasonRepository, EpisodeRepository episodeRepository, ArchiveRepository archiveRepository, FavoriteRepository favoriteRepository, ComentaryRepository comentaryRepository) {
		return args -> {
			PodcastUser adminUser = new PodcastUser("admin", "admin", "admin", "admin@puente4podcast.com", "chile", "admin");
			PodcastUser testUser = new PodcastUser("Marco", "Miquel", "NetRunner", "miquel.marco@outlook.com", "chile", "123");
			Podcast puente4podcast = new Podcast("puente4podcast", "El podcast de la gente que ve el mundo, de otra manera!", "https://imgur.com/rJh1nKq");

			Season season1 = new Season((long) 1);
			Season season2 = new Season((long) 2);
			Season season3 = new Season((long) 3);
			Season season4 = new Season((long) 4);

			Episode episode1x01 = new Episode((byte) 1, (byte) 1, "Cosas como Viajes en el tiempo, Nintendo y experimentos rusos", "https://i.ytimg.com/vi/HCZbEWn328U/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCW9N3Sq2ERk7rNJ6-ZD-koaGSlGg", "https://www.youtube.com/watch?v=HCZbEWn328U", "https://www.ivoox.com/1x01-cosas-como-viajes-tiempo-videojuegos-audios-mp3_rf_60420409_1.html", "1:31:13", "canon", true);
			Episode episode1x02 = new Episode((byte) 1, (byte) 2, "Cosas como Piratas, tu muerte y Elon Musk", "https://i.ytimg.com/vi/lLdsVHjsQz0/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB9glm31mlzCkeTteRxfXe64MHonw", "https://www.youtube.com/watch?v=lLdsVHjsQz0", "https://www.ivoox.com/1x02-cosas-como-piratas-tu-muerte-elon-audios-mp3_rf_60770749_1.html", "1:25:44", "canon", true);
			Episode episode1x03 = new Episode((byte) 1, (byte) 3, "Cosas como Pelis de libros, parásitos y expresiones", "https://i.ytimg.com/vi/X3ivw_LONtk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDVZJHcDl3BDHXQoHFhBiaZGsxBbQ", "https://www.youtube.com/watch?v=X3ivw_LONtk", "https://www.ivoox.com/1x03-cosas-como-pelis-libros-parasitos-y-audios-mp3_rf_61090555_1.html", "1:35:51", "canon", true);
			Episode episode1x04 = new Episode((byte) 1, (byte) 4, "Cosas como Premios IgNovel, especias y espadas de videojuegos", "https://i.ytimg.com/vi/kX6Pe98rbSY/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLC_A67TZ5A1LCW7Fa4rVY8B5quJYQ", "https://www.youtube.com/watch?v=kX6Pe98rbSY", "https://www.ivoox.com/1x04-cosas-como-premios-ig-nobel-especias-y-audios-mp3_rf_61451290_1.html", "1:42:46", "canon", true);
			Episode episode1x05 = new Episode((byte) 1, (byte) 5, "Cosas como 50 cosas, destrucción de videojuegos y enfermedades mentales", "https://i.ytimg.com/vi/a9z9GfaaXCY/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCmkXqiUnX7IbyZKJqomz9H5D6YGw", "https://www.youtube.com/watch?v=a9z9GfaaXCY", "https://www.ivoox.com/1x05-cosas-como-50-cosas-destruccio-769-n-videojuegos-audios-mp3_rf_62632569_1.html", "1:55:36", "canon", false);
			Episode episode1x06 = new Episode((byte) 1, (byte) 6, "Cosas como Tradiciones navideñas, navidad en las trincheras y el origen de Santa Claus", "https://i.ytimg.com/vi/N2GoaWHuXHo/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBAuSZQN6XLKYZZrCWxj5cYOkATPQ", "https://www.youtube.com/watch?v=N2GoaWHuXHo", "https://www.ivoox.com/1x06-cosas-como-tradiciones-navidenas-navidad-la-audios-mp3_rf_63011219_1.html", "1:34:24", "canon", false);
			Episode episode1x07 = new Episode((byte) 1, (byte) 7, "Cosas como Cyberpunk 2077, aliens y caballeros", "https://i.ytimg.com/vi/uN0hSOyGCp4/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCzWINYSBOFWDRFOYy0JKtnKXd9tw", "https://www.youtube.com/watch?v=uN0hSOyGCp4", "https://www.ivoox.com/1x07-cosas-como-cyberpunk-2077-aliens-caballeros-audios-mp3_rf_63337989_1.html", "1:40:15", "canon", false);
			Episode episode1x08 = new Episode((byte) 1, (byte) 8, "Cosas como Cosas como Marvel VS DC, memoria y dinero", "https://i.ytimg.com/vi/oOGIiOQXkwI/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAO5z5lv9kKKkA-7TN0D-9MK11yXg", "https://www.youtube.com/watch?v=oOGIiOQXkwI", "https://www.ivoox.com/1x08-cosas-como-marvel-vs-dc-memoria-y-audios-mp3_rf_63661225_1.html", "1:57:17", "canon", false);
			Episode episode1x09 = new Episode((byte) 1, (byte) 9, "Cosas como Wonder Woman 1984, Warhammer 40K y justas", "https://i.ytimg.com/vi/rzfwS6_zTKA/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDE_mkxPlsx_PnoUb02wDHCuFpJWw", "https://www.youtube.com/watch?v=rzfwS6_zTKA", "https://www.ivoox.com/1x09-cosas-como-wonder-woman-1984-warhammer-40k-audios-mp3_rf_64016955_1.html", "2:01:32", "canon", false);
			Episode episode1x10 = new Episode((byte) 1, (byte) 10, "Cosas como Leyendas, secuestro en Moscú y Dios", "https://i.ytimg.com/vi/6tThBmq0vuk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCA6HH-E-j427tNQjQScDepyIkaCQ", "https://www.youtube.com/watch?v=6tThBmq0vuk", "https://www.ivoox.com/1x10-cosas-como-leyendas-secuestro-moscu-y-audios-mp3_rf_64678183_1.html", "1:45:06", "canon", false);
			Episode episode1x11 = new Episode((byte) 1, (byte) 11, "Cosas como Youtubers y Andorra, 300 y canibalismo", "https://i.ytimg.com/vi/I0JsE5SM--I/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDKhTGbvFHz9-MnzQYjntAI6KB3ww", "https://www.youtube.com/watch?v=I0JsE5SM--I", "https://www.ivoox.com/1x11-cosas-como-youtubers-andorra-300-y-audios-mp3_rf_65037746_1.html", "2:10:00", "canon", false);
			Episode episode1x12 = new Episode((byte) 1, (byte) 12, "Cosas como La mujer muerta, San Valentín mal y parejas de cine", "https://i.ytimg.com/vi/4e0rEygY4UY/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCZw9T-1PpHfkmrY2Bd9NIoQ_msEQ", "https://www.youtube.com/watch?v=4e0rEygY4UY", "https://www.ivoox.com/1x12-cosas-como-la-mujer-muerta-san-valentin-audios-mp3_rf_65409318_1.html", "1:26:14", "canon", false);
			Episode episode1x13 = new Episode((byte) 1, (byte) 13, "Cosas como fallos en superpoderes, los albores de Youtube y acentos latinos", "https://i.ytimg.com/vi/fKt-aUgWdic/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB_LBQ-m-lDaSEewJZ5IHse-DH5XA", "https://www.youtube.com/watch?v=kVccDLs25mI", "https://www.ivoox.com/1x13-cosas-como-fallos-superpoderes-albores-audios-mp3_rf_65744525_1.html", "1:52:59", "canon", false);
			Episode episode1x14 = new Episode((byte) 1, (byte) 14, "Cosas como combates imposibles, Perseverance y el tritono del Diablo", "https://i.ytimg.com/vi/kVccDLs25mI/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBZ-oM-4hrzUQOBeq4v9KxaFI_y9Q", "https://www.youtube.com/watch?v=fKt-aUgWdic", "https://www.ivoox.com/1x14-cosas-como-combates-imposibles-perseverance-el-audios-mp3_rf_66439947_1.html", "1:54:03", "canon", false);
			Episode episode1x15 = new Episode((byte) 1, (byte) 15, "Cosas como Bandas sonoras de videojuegos, Bob Dylan y Metal", "https://i.ytimg.com/vi/WGnWbx1qB9g/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCRKvrqd7mo76VaTlStHHd_UBJ9WA", "https://www.youtube.com/watch?v=WGnWbx1qB9g", "https://www.ivoox.com/1x15-cosas-como-bandas-sonoras-videojuegos-bob-audios-mp3_rf_66749709_1.html", "1:42:33", "canon", false);
			Episode episode1x16 = new Episode((byte) 1, (byte) 16, "Cosas como acertijos, la historia de Twitch y el caso de Elisa Lam", "https://i.ytimg.com/vi/I-hmcSa45w0/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBaVX0hLT3GvuYh2L2XFY4oCSgqeA", "https://www.youtube.com/watch?v=I-hmcSa45w0", "https://www.ivoox.com/1x16-cosas-como-acertijos-historia-twitch-audios-mp3_rf_67453168_1.html", "1:58:43", "canon", false);
			Episode episode1x17 = new Episode((byte) 1, (byte) 17, "Cosas como La liga de la Justicia Snyder cut, dictadores y League of Legends", "https://i.ytimg.com/vi/r_WMkuT87cs/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCs9py4R9CE3tRWkWwqHvrhVw9MWA", "https://www.youtube.com/watch?v=r_WMkuT87cs", "https://www.ivoox.com/1x17-cosas-como-la-liga-justicia-audios-mp3_rf_68381107_1.html", "1:58:09", "canon", false);
			Episode episode1x18 = new Episode((byte) 1, (byte) 18, "Cosas como The Expanse y la terraformación, baneos en twitch y Remasterizaciones", "https://i.ytimg.com/vi/6Tpm-j386fM/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDfMe_W_QxzdNhlBZ10g9FQs-gBzg", "https://www.youtube.com/watch?v=6Tpm-j386fM", "https://www.ivoox.com/1x18-cosas-como-the-expanse-terraformacion-audios-mp3_rf_69078736_1.html", "1:51:42", "canon", false);
			Episode episode1x19 = new Episode((byte) 1, (byte) 19, "Cosas como top 10 Youtube, Tarantino y Brandon Lee", "https://i.ytimg.com/vi/vxEGcDcKzOc/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDgQ5Yi2WAsmt1Ag7w2VU85wx5j2g", "https://www.youtube.com/watch?v=vxEGcDcKzOc", "https://www.ivoox.com/1x19-cosas-como-top-10-youtube-tarantino-y-audios-mp3_rf_69370948_1.html", "1:44:39", "canon", false);
			Episode episode1x20 = new Episode((byte) 1, (byte) 20, "Cosas como top 10 consolas más vendidas, independencia y top animales", "https://i.ytimg.com/vi/dkuErFw5ALI/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCz7P6FHAFuj6aYRMQpGOW6mOIlrw", "https://www.youtube.com/watch?v=dkuErFw5ALI", "https://www.ivoox.com/1x20-cosas-como-top-10-consolas-mas-vendidas-audios-mp3_rf_69751352_1.html", "1:53:49", "canon", false);
			Episode episode1x21 = new Episode((byte) 1, (byte) 21, "Cosas como caracoles, My little pony y El Motín de Esquilache", "https://i.ytimg.com/vi/LBAYhQLycvk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLD1yBREifQVZsgRBOFbjnsdc_qEgQ", "https://www.youtube.com/watch?v=LBAYhQLycvk", "https://www.ivoox.com/1x21-cosas-como-caracoles-my-little-pony-y-audios-mp3_rf_70397805_1.html", "1:35:53", "canon", false);
			Episode episode1x22 = new Episode((byte) 1, (byte) 22, "Cosas como acertijos II, películas mal y top desastres naturales", "https://i.ytimg.com/vi/dBdOWyA07sw/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB3QPtcJU5x7pOesf0d7b5vC5uaFg", "https://www.youtube.com/watch?v=dBdOWyA07sw", "https://www.ivoox.com/1x22-cosas-como-acertijos-ii-peliculas-mal-y-audios-mp3_rf_70706166_1.html", "1:49:49", "canon", false);
			Episode episode1x23 = new Episode((byte) 1, (byte) 23, "Cosas como combates imposibles II, Puente4podcast y quimeras", "https://i.ytimg.com/vi/lfNMPAVUWjk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAhxyqvbxOYBTq6tGm4wbAKUqBG8A", "https://www.youtube.com/watch?v=lfNMPAVUWjk", "https://www.ivoox.com/1x23-cosas-como-combates-imposibles-ii-puente4podcast-y-audios-mp3_rf_71667444_1.html", "2:13:24", "canon", false);

			Episode episode2x01 = new Episode((byte) 2, (byte) 1, "Cosas como Black Lotus, Pena de Muerte y Leyendas Pokemon: Arceus", "https://i.ytimg.com/vi/WhqO4-dJCMc/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLADMe_3gblZezEV3hdghBFCyUEedw", "https://www.youtube.com/watch?v=WhqO4-dJCMc&t=3s", "https://www.ivoox.com/2x01-cosas-como-black-lotus-pena-muerte-audios-mp3_rf_75556705_1.html", "2:02:02", "canon", false);
			Episode episode2x02 = new Episode((byte) 2, (byte) 2, "Cosas como Mundos, Malaz de Steven Erikson y Sumos", "https://i.ytimg.com/vi/HaCfSvvcNUU/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAMuNedmygWqUMoWXWWPd8hGLBLBw", "https://www.youtube.com/watch?v=HaCfSvvcNUU&t=5390s", "https://www.ivoox.com/2x02-cosas-como-mundos-malaz-steven-erikson-audios-mp3_rf_75823690_1.html", "2:02:02", "canon", false);
			Episode episode2x03 = new Episode((byte) 2, (byte) 3, "Matrix Resurrections, borramos una saga y Black Alien Project", "https://i.ytimg.com/vi/QhAbJfqWtvY/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBxYYMEsbRVwMofzxG2j4PdN0kLBA", "https://www.youtube.com/watch?v=QhAbJfqWtvY&t=4650s", "https://www.ivoox.com/2x03-cosas-como-matrix-resurrections-destruccion-sagas-audios-mp3_rf_76506867_1.html", "2:06:07", "canon", false);
			Episode episode2x04 = new Episode((byte) 2, (byte) 4, "Netflix y Big Data, Tania Head y Expresiones vol. 2", "https://i.ytimg.com/vi/HVRM6SvXhZQ/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAV-wKj85hBjHjaAW1_xelI7gSBHw", "https://www.youtube.com/watch?v=HVRM6SvXhZQ", "https://www.ivoox.com/2x04-cosas-como-netflix-big-data-audios-mp3_rf_76603394_1.html", "2:01:59", "canon", false);
			Episode episode2x05 = new Episode((byte) 2, (byte) 5, "PODCAST MAL - El podcast de la gente que no sabe de lo que habla", "https://i.ytimg.com/vi/z3ZnBXynoCI/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDrq8zH1iMH38tOUFRKnA869iQH7w", "https://www.youtube.com/watch?v=z3ZnBXynoCI", "https://www.ivoox.com/2x05-cosas-como-podcast-mal-vol-ii-audios-mp3_rf_76944090_1.html", "1:36:11", "canon", false);
			Episode episode2x06 = new Episode((byte) 2, (byte) 6, "Especial Halloween (Jawelin)", "https://i.ytimg.com/vi/y8nN_wRG79I/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLARsBsiYdeZtCcRmbvuvjp8eoFb2A", "https://www.youtube.com/watch?v=y8nN_wRG79I&t=2629s", "https://www.ivoox.com/2x06-cosas-como-especial-halloween-jawelin-audios-mp3_rf_77457287_1.html", "1:50:50", "canon", false);
			Episode episode2x07 = new Episode((byte) 2, (byte) 7, "IG Nobel Vol II, Gatos Hidráulicos y Pies", "https://i.ytimg.com/vi/0wufJwiaVSQ/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDBRYe2rWF9eX44ScEBq8u1WuLDwA", "https://www.youtube.com/watch?v=0wufJwiaVSQ", "https://www.ivoox.com/2x07-cosas-como-ig-nobel-vol-ii-gatos-audios-mp3_rf_77762980_1.html", "1:58:38", "canon", false);
			Episode episode2x08 = new Episode((byte) 2, (byte) 8, "El Elfo Oscuro de R.A. Salvatore, Undertale y el accidente con Alec Baldwin", "https://i.ytimg.com/vi/mwqnw6kpLA8/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDybP5RmWwdeS7SvR_VYZ9RnMov1w", "https://www.youtube.com/watch?v=mwqnw6kpLA8&t=6180s", "https://www.ivoox.com/2x08-cosas-como-el-elfo-oscuro-r-a-audios-mp3_rf_78080684_1.html", "2:16:56", "canon", false);
			Episode episode2x09 = new Episode((byte) 2, (byte) 9, "Cuentos Disney originales, Relatos de Terror II, ETERNALS", "https://i.ytimg.com/vi/XfRoZQ_fOn8/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLD17z8PPEKwVHGHAQgDqXd0HCSl0Q", "https://www.youtube.com/watch?v=XfRoZQ_fOn8&t=6s", "https://www.ivoox.com/2x09-cosas-como-cuentos-originales-disney-relatos-de-audios-mp3_rf_78562314_1.html", "2:12:23", "canon", false);
			Episode episode2x10 = new Episode((byte) 2, (byte) 10, "Cosmere.es entrevista - Mistborn, Archivo de las tormentas, Brandon Sanderson", "https://i.ytimg.com/vi/uah5vTxNxmY/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDMasaTvr1asfhzPDOegZ-reHKmgQ", "https://www.youtube.com/watch?v=uah5vTxNxmY", "https://www.ivoox.com/2x10-cosas-como-cosmere-es-entrevista-audios-mp3_rf_78987418_1.html", "2:27:28", "canon", false);
			Episode episode2x11 = new Episode((byte) 2, (byte) 11, "Username: Henry - Entrevista Frank Hidalgo-Gato Durán", "https://i.ytimg.com/vi/3ixZjta1x-0/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDozudWleQBKVnSatsxCaXI1bWZhQ", "https://www.youtube.com/watch?v=3ixZjta1x-0", "https://www.ivoox.com/2x11-cosas-como-entrevista-username-henry-frank-hidalgo-gato-audios-mp3_rf_79812809_1.html", "1:40:28", "canon", false);
			Episode episode2x12 = new Episode((byte) 2, (byte) 12, "La Fisica del Cosmere, la MODA y Actores de Hollywood", "https://i.ytimg.com/vi/a4iKt0n1DYA/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCsfk1gV84j2IvzJWdzvWtuWM8X9Q", "https://www.youtube.com/watch?v=a4iKt0n1DYA", "https://www.ivoox.com/2x12-cosas-como-la-fisica-del-cosmere-la-audios-mp3_rf_81083391_1.html", "1:57:14", "canon", false);
			Episode episode2x13 = new Episode((byte) 2, (byte) 13, "Fake News, Microsoft compra Activision-Blizzard y El Método Williams", "https://i.ytimg.com/vi/Pd9MBe-bK60/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDLu94P2KPoLVc6aPgHUqlUh1oYmw", "https://www.youtube.com/watch?v=Pd9MBe-bK60&t=5604s", "https://www.ivoox.com/2x13-cosas-como-fake-news-microsoft-el-audios-mp3_rf_81711585_1.html", "1:46:06", "canon", false);
			Episode episode2x14 = new Episode((byte) 2, (byte) 14, "Combates imposibles, Get Back de los Beatles y Meta", "https://i.ytimg.com/vi/xQEyQsqzpyk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCqmmnspjaAFX6S2UYuIjqR-w6p7g", "https://www.youtube.com/watch?v=xQEyQsqzpyk", "https://www.ivoox.com/2x14-cosas-como-combates-imposibles-get-back-de-audios-mp3_rf_82427220_1.html", "2:06:19", "canon", false);
			Episode episode2x15 = new Episode((byte) 2, (byte) 15, "El Señor de los Anillos: los Anillos de Poder, Relatos de Terror y Reina Roja", "https://i.ytimg.com/vi/SyT9e-2tFzU/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLADfXqJALE65a5hqptbiwyLEoyVlw", "https://www.youtube.com/watch?v=SyT9e-2tFzU", "https://www.ivoox.com/2x15-cosas-como-anillos-poder-relatos-audios-mp3_rf_82599675_1.html", "2:03:28", "canon", false);
			Episode episode2x16 = new Episode((byte) 2, (byte) 16, "A Year of Sanderson - Brandon Sanderson", "https://i.ytimg.com/vi/iqyxZk2JS1w/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDIc2Duv7rWPmieeIZxRxmWDh1OXQ", "https://www.youtube.com/watch?v=iqyxZk2JS1w&t=3380s", "https://www.ivoox.com/2x16-cosas-como-a-year-of-sanderson-audios-mp3_rf_83407125_1.html", "1:36:15", "canon", false);
			Episode episode2x17 = new Episode((byte) 2, (byte) 17, "Archivo de las Tormentas 5 prólogo, Batalla de Stalingrado y Oscars 2022", "https://i.ytimg.com/vi/_8AWn6iknV8/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDHhS_gSKKwsfoZIkxhWEoHXyHZ4A", "https://www.youtube.com/watch?v=_8AWn6iknV8&t=7420s", "https://www.ivoox.com/2x17-cosas-como-archivo-tormentas-5-audios-mp3_rf_85052222_1.html", "2:40:33", "canon", false);
			Episode episode2x18 = new Episode((byte) 2, (byte) 18, "Hogwarts Legacy, cancelan a elxokas, A Los Gatos Ni Tocarlos", "https://i.ytimg.com/vi/hbYJOt9I1Hs/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDaS9M58z9bRDv_Dwc7M52QL1Fvmg", "https://www.youtube.com/watch?v=hbYJOt9I1Hs", "https://www.ivoox.com/2x18-cosas-como-hogwarts-legacy-el-xokas-y-audios-mp3_rf_85419397_1.html", "2:01:58", "canon", false);
			Episode episode2x19 = new Episode((byte) 2, (byte) 19, "Proyecto Hail Mary de Andy Weir, Relatos de Terror, el Asesino Confeso", "https://i.ytimg.com/vi/LuZ2z98vJFM/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCnWhXZe1UZeAibZRnnF0-8ffJbuQ", "https://www.youtube.com/watch?v=LuZ2z98vJFM", "https://www.ivoox.com/2x19-cosas-como-proyecto-hail-mary-relatos-de-audios-mp3_rf_86345376_1.html", "2:11:55", "canon", false);
			Episode episode2x20 = new Episode((byte) 2, (byte) 20, "Proyecto Secreto 4 Brandon Sanderson, Kimetsu no Yaiba, afasia de Bruce Willis", "https://i.ytimg.com/vi/e0DhVn9L7pQ/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLD1iml5CfqY-mOuGVZd-Umn7ZpfZw", "https://www.youtube.com/watch?v=e0DhVn9L7pQ&t=3149s", "https://www.ivoox.com/2x20-cosas-como-kimetsu-no-yaiba-4-proyecto-audios-mp3_rf_86455258_1.html", "2:19:11", "canon", false);
			Episode episode2x21 = new Episode((byte) 2, (byte) 21, "FINAL de Combates Imposibles, Relatos de Terror y La Casa de las Profundidades", "https://i.ytimg.com/vi/yCuFrkgnnc4/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLD0RQUkcLUSGTvgdUxEUONGohLp2Q", "https://www.youtube.com/watch?v=yCuFrkgnnc4&t=2833s", "https://www.ivoox.com/2x21-cosas-como-combates-imposibles-relatos-terror-audios-mp3_rf_87034319_1.html", "2:02:31", "canon", false);
			Episode episode2x22 = new Episode((byte) 2, (byte) 22, "Vientos de Invierno de G.R.R. Martin, Relatos de Terror, Eurovision 2022", "https://i.ytimg.com/vi/qCvks3-htPQ/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAnGwk8uD1nE2d-thQZxqSqQf532w", "https://www.youtube.com/watch?v=qCvks3-htPQ&t=5683s", "https://www.ivoox.com/2x22-cosas-como-vientos-invierno-rr-audios-mp3_rf_87369239_1.html", "1:51:41", "canon", false);
			Episode episode2x23 = new Episode((byte) 2, (byte) 23, "Tatuajes, Aquello que Borrarías de la Historia, Aquí no hay quien viva", "https://i.ytimg.com/vi/C4lPkFlG244/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBEHhbxIHl5Go5cIO_302OYxSu2Cw", "https://www.youtube.com/watch?v=C4lPkFlG244&t=5412s", "https://www.ivoox.com/2x23-cosas-como-tatuajes-aquello-borrarias-de-audios-mp3_rf_88048634_1.html", "1:47:57", "canon", false);
			Episode episode2x24 = new Episode((byte) 2, (byte) 24, "Jurassic Park Saga, Concurso de Relatos y Top Animales Vol 2", "https://i.ytimg.com/vi/AmQDeXUY2Dc/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLABuMmsYCrfK8yD905sZrHO5q-E3A", "https://www.youtube.com/watch?v=AmQDeXUY2Dc", "https://www.ivoox.com/2x24-cosas-como-jurassic-park-fran-green-y-audios-mp3_rf_88303405_1.html", "2:08:01", "canon", false);
			Episode episode2x25 = new Episode((byte) 2, (byte) 25, "Season Finale Temporada 2", "https://i.ytimg.com/vi/KO3Fi40oN8c/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB46yJZvBBaNp8GwwnEUlMuA9Zl6A", "https://www.youtube.com/watch?v=KO3Fi40oN8c", "https://www.ivoox.com/2x25-cosas-como-season-finale-temporada-2-audios-mp3_rf_88978830_1.html", "1:36:21", "canon", false);

			Episode episode3x01 = new Episode((byte) 3, (byte) 1, "Los Anillos de Poder, Historia Targaryen y Elden Ring", "https://i.ytimg.com/vi/nsOwqK6NvWY/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCL1qgYJKtSTpz2USEq0kpPtXcJYw", "https://www.youtube.com/watch?v=nsOwqK6NvWY&t=4686s", "https://www.ivoox.com/3x01-cosas-como-los-anillos-poder-la-audios-mp3_rf_92516350_1.html", "2:25:42", "canon", false);
			Episode episode3x02 = new Episode((byte) 3, (byte) 2, "Miniaturas de El Archivo de las Tormentas, GTA 6, Origen de frases vol 3", "https://i.ytimg.com/vi/iMfp99x0d2o/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLArhgVUSaop5_fCIr7_fq4HuvSNAA", "https://www.youtube.com/watch?v=iMfp99x0d2o&t=4925s", "https://www.ivoox.com/3x02-cosas-como-miniaturas-brandon-sanderson-gta-audios-mp3_rf_92845201_1.html", "2:06:08", "canon", false);
			Episode episode3x03 = new Episode((byte) 3, (byte) 3, "Impresiones de Malaz, The Last of Us HBO y Cyberpunk Edgerunners", "https://i.ytimg.com/vi/FLhR1vghcks/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDtOi_OlQLhOaOOw1ub_k0oJFXz_g", "https://www.youtube.com/watch?v=FLhR1vghcks&t=949s", "https://www.ivoox.com/3x03-cosas-como-impresiones-malaz-the-last-audios-mp3_rf_93206845_1.html", "1:32:33", "canon", false);
			Episode episode3x04 = new Episode((byte) 3, (byte) 4, "La Casa del Dragón Vs Los Anillos de Poder, Chainsaw Man, Bombas Atómicas", "https://i.ytimg.com/vi/GJ-Q3_zeb0Q/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCEqHbaqW8pwtiuf0WgPpUgAB7W0g", "https://www.youtube.com/watch?v=GJ-Q3_zeb0Q", "https://www.ivoox.com/3x04-cosas-como-la-casa-del-dragon-vs-audios-mp3_rf_94056346_1.html", "1:57:12", "canon", false);
			Episode episode3x05 = new Episode((byte) 3, (byte) 5, "Disfraces de Jeffrey Dahmer, sucesos paranormales, videojuegos de terror", "https://i.ytimg.com/vi/P68exb_ReI4/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLA-D_OVUCf9hX_EBLZR5lEBan4Ucg", "https://www.youtube.com/watch?v=P68exb_ReI4", "https://www.ivoox.com/3x05-cosas-como-jeffrey-dahmer-historias-paranormales-y-audios-mp3_rf_95072316_1.html", "2:31:19", "canon", false);
			Episode episode3x06 = new Episode((byte) 3, (byte) 6, "Reparto de Mistborn, proyectos de G.R.R Martin y pantallas de Game Over", "https://i.ytimg.com/vi/u7BKvT-BMRA/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCAFNK-RBBipWEnDkc2ozshSRySvw", "https://www.youtube.com/watch?v=u7BKvT-BMRA&t=6767s", "https://www.ivoox.com/3x06-cosas-como-reparto-mistborn-proyectos-de-audios-mp3_rf_96592998_1.html", "2:14:36", "canon", false);
			Episode episode3x07 = new Episode((byte) 3, (byte) 7, "Reseña sin spoilers de El Metal Perdido, Andor y reset de Los Anillos de Poder", "https://i.ytimg.com/vi/P27QabR2V7I/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBb1Xo4okLHiY4oB4FRGPKz6BCVaw", "https://www.youtube.com/watch?v=P27QabR2V7I&t=379s", "https://www.ivoox.com/3x07-cosas-como-el-metal-perdido-andor-y-audios-mp3_rf_97686782_1.html", "1:57:00", "canon", false);
			Episode episode3x08 = new Episode((byte) 3, (byte) 8, "Combates imposibles, Game Awards 2022, los Sangre Espectral y El Metal Perdido", "https://i.ytimg.com/vi/8uIiZQuHNo4/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAEvboGGSk2OWYXyttpeDO4pPTvHg", "https://www.youtube.com/watch?v=8uIiZQuHNo4&t=16s", "https://www.ivoox.com/3x08-cosas-como-combates-imposibles-game-awards-2023-audios-mp3_rf_99923973_1.html", "2:16:48", "canon", false);
			Episode episode3x09 = new Episode((byte) 3, (byte) 9, "Catálogo juguetes 1995, hombres de dorado y rojo en El Metal Perdido, Avatar 2", "https://i.ytimg.com/vi/HYBv8W_6NlY/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDTFuDrVLuINnUdaWwooP-FTN2Mdg", "https://www.youtube.com/watch?v=HYBv8W_6NlY", "https://www.ivoox.com/3x09-cosas-como-catalogo-juguetes-1995-hombres-de-audios-mp3_rf_100402075_1.html", "2:39:04", "canon", false);
			Episode episode3x10 = new Episode((byte) 3, (byte) 10, "PODCAST MAL 3 - El podcast de la gente que no sabe de lo que habla", "https://i.ytimg.com/vi/23sHYM4jDx0/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBsMiyIxRr-n927ndAzmcxwryV8Gw", "https://www.youtube.com/watch?v=23sHYM4jDx0&t=5s", "https://www.ivoox.com/3x10-cosas-como-el-podcast-mal-3-audios-mp3_rf_100654814_1.html", "1:45:46", "canon", false);
			Episode episode3x11 = new Episode((byte) 3, (byte) 11, "Combates Imposibles, reseña de Miercoles (Merlina), Henry Cavill y Warhammer", "https://i.ytimg.com/vi/tsC5hJjKWAI/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCUrDPddA06HWS3RSZsEHICpisV-A", "https://www.youtube.com/watch?v=tsC5hJjKWAI", "https://www.ivoox.com/3x11-cosas-como-combates-imposibles-miercoles-henry-cavill-audios-mp3_rf_102173093_1.html", "2:25:50", "canon", false);
			Episode episode3x12 = new Episode((byte) 3, (byte) 12, "Consultorio de la Davidcracia, Esencias del Cosmere, la Ballena Brendan Fraser", "https://i.ytimg.com/vi/VJ4PA16g19Y/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBJ2ypYqeOGahls3wM-4esVzHeiCg", "https://www.youtube.com/watch?v=VJ4PA16g19Y&t=4458s", "https://www.ivoox.com/3x12-cosas-como-el-consultorio-davidcracia-audios-mp3_rf_102945979_1.html", "2:53:41", "canon", false);
			Episode episode3x13 = new Episode((byte) 3, (byte) 13, "Hogwarts Legacy, Terraplanismo, La Voz de las Espadas de Abercrombie", "https://i.ytimg.com/vi/cYN8trONijA/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCyra94fRPHYuv8FSamsFC_8zqjBw", "https://www.youtube.com/watch?v=cYN8trONijA&t=489s", "https://www.ivoox.com/3x13-cosas-como-hogwarts-legacy-terraplanismo-joe-audios-mp3_rf_103306614_1.html", "2:00:39", "canon", false);
			Episode episode3x14 = new Episode((byte) 3, (byte) 14, "Fancast español de Mistborn, Verbolario de R. Cortés, Dogfight Wild Tournament", "https://i.ytimg.com/vi/K2qWk1qW3JY/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCn9v5DMtsGLd2Umw9HRnG4bM7OYw", "https://www.youtube.com/watch?v=K2qWk1qW3JY", "https://www.ivoox.com/3x14-cosas-como-fancast-espanol-mistborn-verbolario-audios-mp3_rf_104077547_1.html", "2:01:08", "canon", false);
			Episode episode3x15 = new Episode((byte) 3, (byte) 15, "David Hates, Kaladin por The Black Piper, probamos Chat GPT", "https://i.ytimg.com/vi/ZvjcDiUmkT0/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBr6CaSiWte3U_c_VVdCw7U2e5VsA", "https://www.youtube.com/watch?v=ZvjcDiUmkT0&t=1691s", "https://www.ivoox.com/3x15-cosas-como-david-hates-kaladin-the-black-audios-mp3_rf_105167103_1.html", "1:52:20", "canon", false);
			Episode episode3x16 = new Episode((byte) 3, (byte) 16, "Revistas Superpop, Cosplay: talyBb, artículo de Jason Kehe", "https://i.ytimg.com/vi/ebzMEgavZzM/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCt6f71uzkbrIm66q8aBUghFsIjUw", "https://www.youtube.com/watch?v=ebzMEgavZzM", "https://www.ivoox.com/3x16-cosas-como-revistas-superpop-talybb-cosplay-jason-audios-mp3_rf_105623293_1.html", "2:16:18", "canon", false);
			Episode episode3x17 = new Episode((byte) 3, (byte) 17, "El Reboot de Harry Potter, Outside de Brandon Sanderson, reseña: Dungeons & Dragons", "https://i.ytimg.com/vi/roAcPJZUjXc/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDyi01aGZ7-DRKJub47DFYjNQyrfQ", "https://www.youtube.com/watch?v=roAcPJZUjXc", "https://www.ivoox.com/3x17-cosas-como-reboot-harry-potter-outside-audios-mp3_rf_106430590_1.html", "2:00:38", "canon", false);
			Episode episode3x18 = new Episode((byte) 3, (byte) 18, "Fan cast español El Archivo de las Tormentas con IA, moda Superpop, saga Zelda", "https://i.ytimg.com/vi/Wjb-0BNIvxM/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCnaQNDWIsZDKXqpy7f46xERwg3Tg", "https://www.youtube.com/watch?v=Wjb-0BNIvxM", "https://www.ivoox.com/3x18-cosas-como-fancast-del-archivo-las-audios-mp3_rf_107625642_1.html", "2:36:29", "canon", false);
			Episode episode3x19 = new Episode((byte) 3, (byte) 19, "Fan cast El Archivo de las Tormentas con IA, Zelda TOTK, Eurovision 2023", "https://i.ytimg.com/vi/baCUb--9c4w/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAEkL5QTZbYJTO7Ddzc8c_i7XkY-Q", "https://www.youtube.com/watch?v=baCUb--9c4w", "https://www.ivoox.com/3x19-cosas-como-fancast-archivo-tormentas-audios-mp3_rf_108515626_1.html", "2:24:33", "canon", false);
			Episode episode3x20 = new Episode((byte) 3, (byte) 20, "Malaz: Memorias de Hielo, Moldeadores de Alma, nuevo libro de Patrick Rothfuss", "https://i.ytimg.com/vi/TWB--TY0x4Q/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBPeWvNLrYkcC4CZuox5JsHmjtHgA", "https://www.youtube.com/watch?v=TWB--TY0x4Q", "https://www.ivoox.com/3x20-cosas-como-malaz-memorias-hielo-moldeadores-audios-mp3_rf_108972596_1.html", "2:05:00", "canon", false);
			Episode episode3x21 = new Episode((byte) 3, (byte) 21, "Diablo IV, Los Tonos de Roshar con @Pabloglezcas y test de ligue Superpop", "https://i.ytimg.com/vi/PBPS_wxWwEk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLD2moLBl-idW2Ndd_6-eqb9Ra3o4Q", "https://www.youtube.com/watch?v=PBPS_wxWwEk", "https://www.ivoox.com/3x21-cosas-como-diablo-iv-tonos-puros-audios-mp3_rf_110048632_1.html", "2:31:59", "canon", false);
			Episode episode3x22 = new Episode((byte) 3, (byte) 22, "Combates Imposibles, Starfield, libros de fantasía con Tamara de @Cosmere_es", "https://i.ytimg.com/vi/5uAmQrAUq_I/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDT6YXfXNkvNYYuL1JgER8UkkjJwg", "https://www.youtube.com/watch?v=5uAmQrAUq_I", "https://www.ivoox.com/3x22-cosas-como-combates-imposibles-starfield-literatura-audios-mp3_rf_110549060_1.html", "2:14:05", "canon", false);
			Episode episode3x23 = new Episode((byte) 3, (byte) 23, "Season Finale Temporada 3", "https://i.ytimg.com/vi/AXDchl0fRHk/maxresdefault.jpg", "https://www.youtube.com/watch?v=AXDchl0fRHk", "https://www.ivoox.com/3x23-cosas-como-season-finale-audios-mp3_rf_112042580_1.html", "2:27:27", "canon", false);

			Episode episode4x01 = new Episode((byte) 4, (byte) 1, "Baldur's Gate 3 GOTY, One Piece Live Action (no spoilers), H.P. Lovecraft", "https://i.ytimg.com/vi/mcUi41gUfCo/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAwo5zuGihapur_EcwLtGzI-2ht-w", "https://www.youtube.com/watch?v=mcUi41gUfCo&t=6371s", "https://www.ivoox.com/4x01-cosas-como-baldur-s-gate-3-one-piece-audios-mp3_rf_116010809_1.html", "2:00:17", "canon", true);

			Archive archivex001 = new Archive((byte) 1, "EL ARCHIVO DE LAS TORMENTAS: RESEÑA BRANDON SANDERSON", "https://i.ytimg.com/vi/qZwE2LDw42E/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLASV5xu-_TjTt0VYh0u-Ih0HI8K9A", "https://www.youtube.com/watch?v=qZwE2LDw42E", "https://www.ivoox.com/arch-1-brandon-sanderson-archivo-de-audios-mp3_rf_62210556_1.html", "2:09:39", "archive", true);

			Comentary testCommentary = new Comentary("This is a test commentary, and is too short so i will put something more", LocalDateTime.now());

			Favorite testFavorite = new Favorite();

			List<Season> seasonList = Arrays.asList(season1, season2, season3, season4);
			List<Episode> episodeListS1 = Arrays.asList(episode1x01, episode1x02, episode1x03, episode1x04, episode1x05, episode1x06, episode1x07, episode1x08, episode1x09, episode1x10,
					episode1x11, episode1x12, episode1x13, episode1x14, episode1x15, episode1x16, episode1x17, episode1x18, episode1x19, episode1x20, episode1x21, episode1x22, episode1x23);
			List<Episode> episodeListS2 = Arrays.asList(episode2x01, episode2x02, episode2x03, episode2x04, episode2x05, episode2x06, episode2x07, episode2x08, episode2x09, episode2x10,
					episode2x11, episode2x12, episode2x13, episode2x14, episode2x15, episode2x16, episode2x17, episode2x18, episode2x19, episode2x20, episode2x21, episode2x22, episode2x23,
					episode2x24, episode2x25);
			List<Episode> episodeListS3 = Arrays.asList(episode3x01, episode3x02, episode3x03, episode3x04, episode3x05, episode3x06, episode3x07, episode3x08, episode3x09, episode3x10,
					episode3x11, episode3x12, episode3x13, episode3x14, episode3x15, episode3x16, episode3x17, episode3x18, episode3x19, episode3x20,episode3x21, episode3x22, episode3x23);
			List<Episode> episodeListS4 = Arrays.asList(episode4x01);


			puente4podcast.addPodcastUser(adminUser);
			puente4podcast.addAllSeasons(seasonList);
			puente4podcast.addArchive(archivex001);
			season1.addAllEpisodes(episodeListS1);
			season2.addAllEpisodes(episodeListS2);
			season3.addAllEpisodes(episodeListS3);
			season4.addAllEpisodes(episodeListS4);
			episode1x01.addComentary(testCommentary);
			episode1x01.addFavorite(testFavorite);
			adminUser.addFavorite(testFavorite);
			adminUser.addComentary(testCommentary);

			podcastRepository.save(puente4podcast);
			podcastUserRepository.save(adminUser);
			podcastUserRepository.save(testUser);
			seasonRepository.saveAll(seasonList);
			archiveRepository.save(archivex001);
			episodeRepository.saveAll(episodeListS1);
			episodeRepository.saveAll(episodeListS2);
			episodeRepository.saveAll(episodeListS3);
			episodeRepository.saveAll(episodeListS4);
			favoriteRepository.save(testFavorite);
			comentaryRepository.save(testCommentary);
		};
	}
}