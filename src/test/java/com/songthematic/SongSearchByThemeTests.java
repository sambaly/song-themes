package com.songthematic;

import com.songthematic.songthemes.Song;
import com.songthematic.songthemes.SongSearcher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SongSearchByThemeTests {

    @Test
    void searchForThemeThatDoesNotExistReturnsNoResults() {
        SongSearcher songSearcher = SongSearcher.withSongsForTheme("New Years");

        List<String> foundSongs = songSearcher.byTheme("AppleSauce");

        assertThat(foundSongs)
                .isEmpty();
    }

    @Test
    void searchForThemeFindsOneMatchingSong() {
        SongSearcher songSearcher = SongSearcher.createSongSearcher(new Song("New Years", "auld lang syne"));

        List<String> foundSong = songSearcher.byTheme("New Years");

        assertThat(foundSong)
                .containsExactly("auld lang syne");
    }
}
