package com.songthematic;

import com.songthematic.songthemes.SongSearcher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SongSearchByThemeTests {

    @Test
    void searchForThemeThatDoesNotExistReturnsNoResults() {
        SongSearcher songSearcher = new SongSearcher();

        List<String> foundSongs = songSearcher.byTheme("AppleSauce");

        assertThat(foundSongs)
                .isEmpty();
    }

    @Test
    void searchForThemeFindsOneMatchingSong() {
        SongSearcher songSearcher = new SongSearcher();

        List<String> foundSong = songSearcher.byTheme("New Years");

        assertThat(foundSong)
                .containsExactly("auld lang syne");
    }
}
