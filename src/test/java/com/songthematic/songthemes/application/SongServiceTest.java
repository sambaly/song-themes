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

        songService.addSong(new Song("new years", "This Will Be Our Year"));
        songService.addSong(new Song("new years", "Funky New Year"));

        List<Song> songsFound = songService.searchByTheme("new years");

        assertThat(songsFound)
                .containsExactly(
                        new Song("new years", "This Will Be Our Year"),
                        new Song("new years", "Funky New Year")
                );
    }

    /*@Test
    void songWithMultipleThemesIsFoundByAnyOfThoseThemes() {
        SongService songService = new SongService();
        songService.addSong(new Song(List.of("Christmas", "Halloween"), "Nightmare Before Christmas"));
    }*/

    @Test
    void savedSongsLoadedOnStartup() {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("Fire", "Baby's on Fire"));

        SongRepository songRepository = SongRepository.create(songList);
        SongService songService = new SongService(songRepository);

        assertThat(songService.searchByTheme("Fire"))
                .containsExactly(new Song("Fire", "Baby's on Fire"));
    }

    @Test
    void addedSongsAreSavedToRepository() {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("Fire", "Baby's on Fire"));
        SongRepository songRepository = SongRepository.create(songList);
        SongService songService = new SongService(songRepository);

        songService.addSong(new Song("Fire", "Smokestack Lightning"));

        assertThat(songRepository.allSongs())
                .hasSize(2);
    }
}
