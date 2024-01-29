package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TsvSongParserTest {

    @Test
    void parseSongFromTabSeparatedValues() {
        String csvSongs = "Earth, Wind & Fire\tGratitude\tReleaseTitle\tReleaseType\tNotes\tThank You\tThanks\tGratitude\tTheme4\tRizzi";

        TsvSongParser tsvSongParser = new TsvSongParser();
        List<Song> songs = tsvSongParser.parse(csvSongs);

        assertThat(songs)
                .containsExactly(new Song("Earth, Wind & Fire", "Gratitude",
                        "ReleaseTitle", "ReleaseType", List.of("Thank You", "Thanks", "Gratitude", "Theme4")));
    }

    @Test
    @Disabled
    void parseSongWithOnlyOneThemeHasOneTheme() {
        String csvSongs = "DontCareArtist\tDontCareSongTitle\tDontCareReleaseTitle\tDontCareReleaseType\tNotes\tThank You\t\t\tDontCareContributor";

        TsvSongParser tsvSongParser = new TsvSongParser();
        List<Song> songs = tsvSongParser.parse(csvSongs);

        assertThat(songs)
                .containsExactly(new Song("DontCareArtist", "DontCareSongTitle",
                        "DontCareReleaseTitle", "DontCareReleaseType", List.of("Thank You")));
    }
}