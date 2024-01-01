package com.songthematic.songthemes.adapter.in.web;

import com.songthematic.songthemes.domain.Song;
import com.songthematic.songthemes.domain.SongSearcher;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SongThemesControllerTest {


    @Test
    void searchReturnsModelWithEmptySearchResults() {
        String theme = "New Years";
        String songTitle = "auld lang syne";
        SongThemesController songThemesController = createSongThemesController(new Song(theme, songTitle));
        Model model = new ConcurrentModel();

        String viewName = songThemesController.themeSearch("christmas", model);

        assertThat(viewName)
                .isEqualTo("theme-search-no-results");
    }

    @Test
    void searchReturnsModelWithNonEmptySearchResults() {
        String theme = "New Years";
        SongThemesController songThemesController = createSongThemesController(new Song(theme, "auld lang syne"),
                new Song(theme, "New Year's Eve In A Haunted House"));
        Model model = new ConcurrentModel();

        String viewName = songThemesController.themeSearch("New Years", model);
        List<SongView> searchResults = (List<SongView>) model.getAttribute("searchResults");

        assertThat(viewName)
                .isEqualTo("theme-search-has-results");

        assertThat(searchResults)
                .containsExactly(new SongView("auld lang syne"),
                        new SongView("New Year's Eve In A Haunted House"));

    }

    private static SongThemesController createSongThemesController(Song... songs) {
        return new SongThemesController(SongSearcher.createSongSearcher(songs));
    }
}