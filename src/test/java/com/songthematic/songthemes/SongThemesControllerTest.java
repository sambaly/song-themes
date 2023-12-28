package com.songthematic.songthemes;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;

class SongThemesControllerTest {

    @Test
    void searchReturnsSearchResultsView() {
        SongThemesController songThemesController = new SongThemesController(SongSearcher.withOneSong());
        Model model = new ConcurrentModel();

        String viewName = songThemesController.themeSearch("", model);

        assertThat(viewName)
                .isEqualTo("theme-search-results");
    }


    @Test
    void searchReturnsModelWithEmptySearchResults() {
        String theme = "New Years";
        String songTitle = "auld lang syne";
        SongThemesController songThemesController = new SongThemesController(
                SongSearcher.createSongSearcher(theme, songTitle));
        Model model = new ConcurrentModel();

        songThemesController.themeSearch("christmas", model);

        assertThat(model.getAttribute("emptySearchResults"))
                .isEqualTo(Boolean.TRUE);
    }

    @Test
    void searchReturnsModelWithNonEmptySearchResults() {
        String theme = "New Years";
        String songTitle = "auld lang syne";
        SongThemesController songThemesController = new SongThemesController(
                SongSearcher.createSongSearcher(theme, songTitle));
        Model model = new ConcurrentModel();

        songThemesController.themeSearch("New Years", model);

        assertThat(model.getAttribute("emptySearchResults"))
                .isEqualTo(Boolean.FALSE);
    }
}