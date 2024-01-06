package com.songthematic.songthemes.domain;

import java.util.List;

public record Song(List<String> theme, String title) {
    public Song(String theme, String title) {
        this(List.of(theme), title);
    }
}