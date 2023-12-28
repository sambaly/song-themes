package com.songthematic.songthemes;

import java.util.Collections;
import java.util.List;

public class SongSearcher {

    private final String theme;
    private final String song;

    private SongSearcher(Song... songs) {
        this.theme = songs[0].theme();
        this.song = songs[0].title();
    }

    public static SongSearcher createSongSearcher(Song... songs) {
        return new SongSearcher(songs[0]);
    }

    public static SongSearcher withSongsForTheme(String theme) {
        return new SongSearcher(new Song(theme, "Song with theme " + theme));
    }

    public static SongSearcher withOneSong() {
        return createSongSearcher(new Song("New Years", "auld lang syne"));
    }

    public List<String> byTheme(String requestedTheme) {
        if (requestedTheme.equalsIgnoreCase(theme)) {
            return List.of(song);
        }
        return Collections.emptyList();
    }
}
