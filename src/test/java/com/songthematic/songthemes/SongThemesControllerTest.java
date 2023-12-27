package com.songthematic.songthemes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SongThemesControllerTest {

    @Test
    void getSearchReturnsSearchResultsView() {
        SongThemesController songThemesController = new SongThemesController();

        String viewName = songThemesController.themeSearch();

        assertThat(viewName)
                .isEqualTo("theme-search-results");
    }

}