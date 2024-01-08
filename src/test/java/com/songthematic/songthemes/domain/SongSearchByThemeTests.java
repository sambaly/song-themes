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
        SongSearcher songSearcher = SongSearcher.createSongSearcher(new Song("auld lang syne", List.of(songTheme)));

        List<String> foundSong = songSearcher.songTitlesByTheme(requestedTheme);

        assertThat(foundSong)
                .containsExactly("auld lang syne");
    }

    @Test
    void searchForThemeFindsMultipleMatchingSongs() {
        SongSearcher songSearcher = SongSearcher.createSongSearcher(
                new Song("auld lang syne", List.of("New Years")),
                new Song("New Year's Eve In A Haunted House", List.of("New years")));

        List<String> foundSongs = songSearcher.songTitlesByTheme("New Years");

        assertThat(foundSongs)
                .containsExactly("auld lang syne", "New Year's Eve In A Haunted House");

    }

    @Test
    void forSongsWithDifferentThemesSearchFindsAllSongs() {
        SongSearcher songSearcher = SongSearcher.createSongSearcher(
                new Song("auld lang syne", List.of("New Years")),
                new Song("The Christmas Tree is on Fire", List.of("christmas")));

        assertThat(songSearcher.songTitlesByTheme("New Years"))
                .containsExactly("auld lang syne");

        assertThat(songSearcher.songTitlesByTheme("Christmas"))
                .containsExactly("The Christmas Tree is on Fire");
    }

    @Test
    void songWithMultipleThemesIsFoundByItsSecondTheme() {
        SongSearcher songSearcher = SongSearcher.createSongSearcher(new Song("Nightmare Before Christmas", List.of("Christmas", "Halloween")));

        List<Song> songsFound = songSearcher.byTheme("halloween");

        assertThat(songsFound)
                .extracting(Song::title)
                .containsExactly("Nightmare Before Christmas");
    }
}
