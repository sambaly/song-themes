package com.songthematic.songthemes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SongThemesControllerTest {

    @Test
    void postSearchRedirectsToSearchResults() {
        SongThemesController songThemesController = new SongThemesController();

        String redirectPage = songThemesController.themeSearch();

        assertThat(redirectPage)
                .isEqualTo("redirect:/theme-search-results");
    }
}