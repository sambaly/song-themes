package com.songthematic.songthemes.domain;

import java.util.List;

public record Song(List<String> themes, String title) {
    public Song(String theme, String title) {
        this(List.of(theme), title);
    }
}