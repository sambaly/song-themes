package com.songthematic;

import com.songthematic.songthemes.Song;
import com.songthematic.songthemes.SongSearcher;
import com.songthematic.songthemes.SongView;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SongSearchByThemeTests {

    @Test
    void searchForThemeThatDoesNotExistReturnsNoResults() {
        SongSearcher songSearcher = SongSearcher.withOneSongForTheme("New Years");

        List<String> foundSongs = songSearcher.byTheme("AppleSauce");

        assertThat(foundSongs)
                .isEmpty();
    }

    @ParameterizedTest()
    @CsvSource({
            "new years, New Years",
            "new years, new years",
            "New Years, New Years",
            "New Years, new years",
    })
    void searchForThemeFindsOneMatchingSongIgnoringCase(String songTheme, String requestedTheme) {
        SongSearcher songSearcher = SongSearcher.createSongSearcher(new Song(songTheme, "auld lang syne"));

        List<String> foundSong = songSearcher.byTheme(requestedTheme);

        assertThat(foundSong)
                .containsExactly("auld lang syne");
    }

    @Test
    @Disabled
    void searchForThemeFindsMultipleMatchingSongs() {
        SongSearcher songSearcher = SongSearcher.createSongSearcher(
                new Song("New Years", "auld lang syne"),
                new Song("New years", "New Year's Eve In A Haunted House"));

        List<String> foundSongs = songSearcher.byTheme("New Years");

        assertThat(foundSongs)
                .containsExactly("auld lang syne", "New Year's Eve In A Haunted House");

    }
}
