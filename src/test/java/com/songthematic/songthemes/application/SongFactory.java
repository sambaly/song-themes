package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;

import java.util.List;

public class SongFactory {
    public static Song createSong(String songTitle, String theme) {
        return createSong(songTitle, List.of(theme));
    }

    public static Song createSong(String songTitle, List<String> themes) {
        return new Song("IrrelevantArtist", songTitle, "IrrelevantReleaseTitle", "IrrelevantReleaseType", themes);
    }

    public static Song createSong(String artist, String songTitle, String releaseTitle, String releaseType, String theme) {
        return new Song(artist, songTitle, releaseTitle, releaseType, List.of(theme));
    }
}
