package com.task.taskmanager;

import com.task.taskmanager.entity.User;
import com.task.taskmanager.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbTestInitializer implements ApplicationRunner {

  private UserRepository userRepository;

  public DbTestInitializer(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("runner");
    User user = new User();
    user.setUsername("mateusz");
    user.setPassword("password");
    userRepository.save(user);
  }
}
