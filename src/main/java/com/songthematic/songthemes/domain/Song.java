package com.songthematic.songthemes.domain;

import java.util.List;

public record Song(String title, List<String> themes) {
}