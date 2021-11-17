package com.github.olvrti.crispy.domain.enums;

public enum Role {
  USER(0, "ROLE_USER"), ADMIN(1, "ROLE_ADMIN");

  private final int id;
  private final String value;

  Role(final int id, final String value) {
    this.id = id;
    this.value = value;
  }

  public int getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  public static Role toEnum(final int id) {
    for (final Role role : Role.values()) {
      if (role.getId() == id) {
        return role;
      }
    }

    throw new IllegalArgumentException(String.format("Invalid id: %d", id));
  }
}
