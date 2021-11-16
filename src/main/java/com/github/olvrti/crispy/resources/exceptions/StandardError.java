package com.github.olvrti.crispy.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer status;
  private String error;
  private String message;
  private Long timestamp;
  private String path;

  public StandardError() {
  }

  public StandardError(final Integer status, final String error, final String message, final Long timestamp,
      final String path) {
    this.status = status;
    this.error = error;
    this.message = message;
    this.timestamp = timestamp;
    this.path = path;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(final String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getPath() {
    return path;
  }

  public void setPath(final String path) {
    this.path = path;
  }

}
