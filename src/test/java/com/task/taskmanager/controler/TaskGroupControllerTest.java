package com.task.taskmanager.controler;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.task.taskmanager.TestSecurityConfiguration;
import com.task.taskmanager.auth.JwtTokenUtil;
import com.task.taskmanager.entity.TaskGroup;
import com.task.taskmanager.fixture.TaskGroupFixture;
import com.task.taskmanager.repository.UserRepository;
import com.task.taskmanager.service.TaskGroupServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = {TaskGroupController.class})
@ContextConfiguration(classes = {TestSecurityConfiguration.class})
class TaskGroupControllerTest {

  @MockBean
  TaskGroupServiceImpl service;

  @MockBean
  UserRepository userRepo;

  @Autowired
  MockMvc mvc;

  @Test
  @WithUserDetails(value = "TEST_USER")
  void getTaskGroups() throws Exception {
    given(service.findTaskGroups()).willReturn(TaskGroupFixture.getTaskGroups());
    mvc.perform(get("/taskGroup"))
        .andExpect(MockMvcResultMatchers.content()
            .json(
                "[{'id':1,'name':'Task1'},{'id':2,'name':'Task2'},{'id':3,'name':'Task3'}]")
        );
  }

}
