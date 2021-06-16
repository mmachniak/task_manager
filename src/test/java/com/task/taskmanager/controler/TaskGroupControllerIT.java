package com.task.taskmanager.controler;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class TaskGroupControllerIT {

  @Autowired
  private MockMvc mvc;

  @Test
  @WithUserDetails(value = "mmachniak")
  void getTaskGroups() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/taskGroup");
    mvc.perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
        .andReturn();
  }

  @Test
  @WithUserDetails(value = "mmachniak")
  void addTaskGroups() throws Exception {
    final String newTaskGroupName = "Bankowa promocja";
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/taskGroup")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"" + newTaskGroupName + "\"}");
    MvcResult $ = mvc.perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.equalTo(newTaskGroupName)))
        .andReturn();
    System.out.println($.getResponse().getContentAsString());
  }

}