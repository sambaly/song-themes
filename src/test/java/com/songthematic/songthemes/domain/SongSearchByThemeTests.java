package com.songthematic.songthemes.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SongSearchByThemeTests {

    @Test
    void searchForThemeThatDoesNotExistReturnsNoResults() {
        SongSearcher songSearcher = SongSearcher.withOneSongForTheme("New Years");

        List<String> foundSongs = songSearcher.songTitlesByTheme("AppleSauce");

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

        List<String> foundSong = songSearcher.songTitlesByTheme(requestedTheme);

        assertThat(foundSong)
                .containsExactly("auld lang syne");
    }

    @Test
    void searchForThemeFindsMultipleMatchingSongs() {
        SongSearcher songSearcher = SongSearcher.createSongSearcher(
                new Song("New Years", "auld lang syne"),
                new Song("New years", "New Year's Eve In A Haunted House"));

        List<String> foundSongs = songSearcher.songTitlesByTheme("New Years");

        assertThat(foundSongs)
                .containsExactly("auld lang syne", "New Year's Eve In A Haunted House");

    }

    @Test
    void forSongsWithDifferentThemesSearchFindsAllSongs() {
        SongSearcher songSearcher = SongSearcher.createSongSearcher(
                new Song("New Years", "auld lang syne"),
                new Song("christmas", "The Christmas Tree is on Fire"));

        assertThat(songSearcher.songTitlesByTheme("New Years"))
                .containsExactly("auld lang syne");

        assertThat(songSearcher.songTitlesByTheme("Christmas"))
                .containsExactly("The Christmas Tree is on Fire");
    }
}
