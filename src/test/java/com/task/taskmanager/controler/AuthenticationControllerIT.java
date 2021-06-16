package com.task.taskmanager.controler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.task.taskmanager.dto.AuthRequest;
import com.task.taskmanager.dto.AuthResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthenticationControllerIT {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void loginSuccessTest() {
    AuthRequest request = new AuthRequest("mateusz", "password");
    ResponseEntity<AuthResponse> authResponseResponseEntity =
        restTemplate.postForEntity("/auth/login", request, AuthResponse.class);
    assertEquals(HttpStatus.OK, authResponseResponseEntity.getStatusCode());
    assertNotNull(authResponseResponseEntity.getBody().getToken());
    assertEquals("mateusz", authResponseResponseEntity.getBody().getUsername());
  }

  @Test
  void loginFailureTest() {
    AuthRequest request = new AuthRequest("notExistUserName", "password");
    ResponseEntity<AuthResponse> authResponseResponseEntity =
        restTemplate.postForEntity("/auth/login", request, AuthResponse.class);
    assertEquals(HttpStatus.UNAUTHORIZED, authResponseResponseEntity.getStatusCode());
  }

}