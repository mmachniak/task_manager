package com.task.taskmanager.controler;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class TaskGroupControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithUserDetails(value = "mmachniak")
    void getTaskGroups() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/taskGroup");
        mvc.perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }

}