package com.github.olvrti.crispy.services;

import java.util.List;
import java.util.Optional;

import com.github.olvrti.crispy.domain.User;
import com.github.olvrti.crispy.repositories.UserRepository;
import com.github.olvrti.crispy.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User find(final Integer id) {
    final Optional<User> user = repository.findById(id);
    return user.orElseThrow(() -> new ObjectNotFoundException(String.format("User not found: %d", id)));
  }

  public User create(final User user) {
    return repository.save(user);
  }

  public User update(final User user) {
    find(user.getId());
    return repository.save(user);
  }

  public void delete(final Integer id) {
    find(id);
    repository.deleteById(id);
  }

}
