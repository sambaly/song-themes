package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SongServiceTest {

    @Test
    void noSongsAddedThenNoSoungsFound() {
        SongService songService = new SongService();

        List<Song> songsFound = songService.searchByTheme("new years");

        assertThat(songsFound)
                .isEmpty();
    }

    @Test
    void oneSongAddedIsFoundByItsTheme() {
        SongService songService = new SongService();

        songService.addSong(new Song("new years", "This Will Be Our Year"));

        List<Song> songsFound = songService.searchByTheme("new years");

        assertThat(songsFound)
                .containsExactly(new Song("new years", "This Will Be Our Year"));

    }
}
