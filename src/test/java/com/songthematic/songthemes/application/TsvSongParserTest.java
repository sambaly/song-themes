package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TsvSongParserTest {

    @Test
    void parseSongFromTabSeparatedValues() {
        String csvSongs = "Earth, Wind & Fire\tGratitude\tThank You\tThanks Gratitude\tRizzi";

        TsvSongParser tsvSongParser = new TsvSongParser();

        List<Song> songs = tsvSongParser.parse(csvSongs);

        assertThat(songs)
                .extracting(Song::artist)
                .containsExactly("Earth, Wind & Fire");
    }
}