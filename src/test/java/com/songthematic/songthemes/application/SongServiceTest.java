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
}