package com.github.olvrti.crispy.resources;

import java.net.URI;
import java.util.List;

import com.github.olvrti.crispy.domain.User;
import com.github.olvrti.crispy.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {
  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok().body(service.findAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> find(@PathVariable final Integer id) {
    return ResponseEntity.ok().body(service.find(id));
  }

  @PostMapping
  public ResponseEntity<User> create(@RequestBody final User userData) {
    final User user = service.create(userData);
    final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@PathVariable final Integer id, @RequestBody final User userData) {
    userData.setId(id);
    service.update(userData);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable final Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
