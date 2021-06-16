package com.task.taskmanager;

import com.task.taskmanager.auth.JwtTokenUtil;
import com.task.taskmanager.entity.User;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@TestConfiguration
public class TestSecurityConfiguration {

  @Bean
  public JwtTokenUtil jwtTokenUtil() {
    return new JwtTokenUtil();
  }

  @Bean
  @Primary
  public UserDetailsService userDetailsService() {
    User basicUser = new User();
    basicUser.setUsername("TEST_USER");
    basicUser.setPassword("TEST_PASSWORD");

    return new InMemoryUserDetailsManager(Collections.singletonList(
        basicUser
    ));
  }

}
