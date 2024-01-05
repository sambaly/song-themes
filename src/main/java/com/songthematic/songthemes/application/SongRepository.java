package com.songthematic.songthemes.application;

import com.songthematic.songthemes.domain.Song;

import java.util.List;
import java.util.stream.Stream;

public class SongRepository {
    private List<Song> songs;

    public SongRepository() {}

    static SongRepository create(List<Song> songList) {
        SongRepository songRepository = new SongRepository();
        songRepository.setSongRepository(songList);
        return songRepository;
    }

    public Stream<Song> allSongs() {
        return songs.stream();
    }

    public void setSongRepository(List<Song> songRepository) {
        this.songs = songRepository;
    }

    void add(Song song) {
        songs.add(song);
    }
}