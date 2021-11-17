package com.github.olvrti.crispy.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.github.olvrti.crispy.domain.enums.Role;

@Entity
public class User implements Serializable {
  static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  private String surname;
  private String email;
  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "roles")
  private final Set<Integer> roles = new HashSet<>();

  public User() {
    addRole(Role.USER);
  }

  public User(final Integer id, final String name, final String surname, final String email, final String password) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
    addRole(Role.USER);
  }

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles.stream().map(r -> Role.toEnum(r)).collect(Collectors.toSet());
  }

  public void addRole(final Role role) {
    roles.add(role.getId());
  }

  @Override
  public String toString() {
    return "User [email=" + email + ", name=" + name + ", password=" + password + ", roles=" + roles + ", surname="
        + surname + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final User other = (User) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
