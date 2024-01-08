package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SongServiceTest {

    @Test
    void multipleSongsAddedAreFoundByTheirTheme() {
        SongService songService = new SongService();

        songService.addSong(createSong("This Will Be Our Year", "new years"));
        songService.addSong(createSong("Funky New Year", "new years"));

        List<Song> songsFound = songService.searchByTheme("new years");

        assertThat(songsFound)
                .containsExactly(
                        createSong("This Will Be Our Year", "new years"),
                        createSong("Funky New Year", "new years")
                );
    }

    @Test
    void savedSongsLoadedOnStartup() {
        List<Song> songList = new ArrayList<>();
        songList.add(createSong("Baby's on Fire", "Fire"));

        SongRepository songRepository = SongRepository.create(songList);
        SongService songService = new SongService(songRepository);

        assertThat(songService.searchByTheme("Fire"))
                .containsExactly(createSong("Baby's on Fire", "Fire"));
    }

    @Test
    void addedSongsAreSavedToRepository() {
        List<Song> songList = new ArrayList<>();
        songList.add(createSong("Baby's on Fire", "Fire"));
        SongRepository songRepository = SongRepository.create(songList);
        SongService songService = new SongService(songRepository);

        songService.addSong(createSong("Smokestack Lightning", "Fire"));

        assertThat(songRepository.allSongs())
                .hasSize(2);
    }

    private static Song createSong(String title, String theme) {
        return new Song(title, List.of(theme));
    }
}
