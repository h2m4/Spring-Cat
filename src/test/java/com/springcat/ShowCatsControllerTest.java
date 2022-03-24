package com.springcat;

import com.springcat.Controller.ShowCatsController;
import com.springcat.Model.Cart;
import com.springcat.Model.Cat;
import com.springcat.Model.JdbcCartRepository;
import com.springcat.Model.JdbcCatRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ShowCatsController.class)
public class ShowCatsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JdbcCatRepository catRepo;
    @MockBean
    JdbcCartRepository cartRepo;

    @Test
    public void testShowCats() throws Exception {
        Cat firstCat = new Cat(1L, "Lucy", "female",
                true, false, false,
                "../static/images/cat1.jpeg", "images/cat1.jpeg");
        Cat secondCat = new Cat(2L, "Amy", "female",
                true, false, false,
                "../static/images/cat1.jpeg", "images/cat1.jpeg");
        List<Cat> cats = new ArrayList<>();
        cats.add(firstCat);
        cats.add(secondCat);
        when(catRepo.findAll()).thenReturn(cats);
        mockMvc.perform(get("/cats"))
                .andExpect(status().isOk())
                .andExpect(view().name("cats"))
                .andExpect(model().attribute("cats", hasSize(2)))
                .andExpect(model().attribute("cats", hasItem(
                        allOf(
                                hasProperty("name", is("Lucy"))
                        )
                )))
                .andExpect(model().attribute("cats", hasItem(
                        allOf(
                                hasProperty("name", is("Amy"))
                        )
                )))
                .andDo(print());
    }
}
