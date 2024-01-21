package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CsvSongParserTest {

    @Test
    void parseSongFromCsv() {
        String csvSongs = "\"Artist\",\"SongTitle\",\"ReleaseTitle\",\"ReleaseType\",\"Theme\"";
        CsvSongParser csvSongParser = new CsvSongParser();

        List<Song> songs = csvSongParser.parse(csvSongs);

        assertThat(songs)
                .containsExactly(SongFactory.createSong("SongTitle", "Theme"));
    }
}