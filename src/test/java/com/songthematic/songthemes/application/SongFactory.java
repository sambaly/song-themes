package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;

import java.util.List;

public class SongFactory {
    public static Song createSong(String title, String theme) {
        return new Song(title, List.of(theme));
    }
}
