package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;

import java.util.List;

public class SongFactory {
    public static Song createSong(String title, String theme) {
        return createSong(title, List.of(theme));
    }

    public static Song createSong(String title, List<String> themes) {
        return new Song(title, themes);
    }
}
