package com.songthematic.songthemes.domain;

import java.util.List;

public record Song(String songTitle, List<String> themes) {
}