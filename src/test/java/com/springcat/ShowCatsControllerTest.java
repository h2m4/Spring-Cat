package com.springcat;

import com.springcat.Controller.ShowCatsController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ShowCatsController.class)
public class ShowCatsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCatsPage() throws Exception {
        mockMvc.perform(get("/cats"))
                .andExpect(status().isOk());
    }
}
