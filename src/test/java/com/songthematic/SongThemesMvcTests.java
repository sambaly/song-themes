package com.songthematic;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Tag("io")
public class SongThemesMvcTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void postToSearchEndpointRedirects() throws Exception {
        mockMvc.perform(post("/theme-search"))
                .andExpect(status().is3xxRedirection());
    }
}
