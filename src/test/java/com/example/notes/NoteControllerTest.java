package com.example.notes;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(NoteController.class)
class NoteControllerTest {

    @Autowired
    MockMvc mvc;

    @MockitoBean
    NoteRepository repository;

    @Test
    void listReturnsOk() throws Exception {
        when(repository.findAll()).thenReturn(List.of());
        mvc.perform(get("/api/notes")).andExpect(status().isOk());
    }
}
