package com.springcat;

import com.springcat.Controller.CatPageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CatPageController.class)
public class CatPageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCatPage() throws Exception {
        mockMvc.perform(get("/cat"))
                .andExpect(status().isOk())
                .andExpect(view().name("cat"))
                .andExpect(content().string(containsString("Miao")));
    }
}

