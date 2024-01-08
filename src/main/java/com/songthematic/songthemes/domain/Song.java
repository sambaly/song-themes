package com.songthematic.songthemes.domain;

import java.util.List;

public record Song(String title, List<String> themes) {
    public Song(String theme, String title) {
        this(title, List.of(theme));
    }
}