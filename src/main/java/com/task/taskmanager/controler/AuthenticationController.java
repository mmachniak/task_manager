package com.task.taskmanager.controler;

import com.task.taskmanager.auth.JwtTokenUtil;
import com.task.taskmanager.dto.AuthRequest;
import com.task.taskmanager.dto.AuthResponse;
import com.task.taskmanager.entity.User;
import com.task.taskmanager.mapper.StructMapper;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(exposedHeaders = {"Authorization"})
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final StructMapper mapper;

  public AuthenticationController(AuthenticationManager authenticationManager,
                                  JwtTokenUtil jwtTokenUtil, StructMapper mapper) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.mapper = mapper;
  }

  @PostMapping("login")
  public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
    try {
      var authenticate = authenticationManager
          .authenticate(
              new UsernamePasswordAuthenticationToken(
                  request.getUsername(), request.getPassword()
              )
          );

      var user = (User) authenticate.getPrincipal();
      AuthResponse authResponse = mapper.toAuthResponse(user);
      authResponse.setToken(jwtTokenUtil.generateAccessToken(user));
      return ResponseEntity.ok()
          .body(authResponse);

    } catch (BadCredentialsException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }


}
