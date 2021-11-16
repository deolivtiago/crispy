package com.github.olvrti.crispy.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
  static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  private String description;
  private Double price;
  private String image;
  private String category;

  public Product() {
  }

  public Product(final Integer id, final String name, final String description, final Double price, final String image,
      final String category) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.image = image;
    this.category = category;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(final Double price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(final String image) {
    this.image = image;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(final String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Product [category=" + category + ", description=" + description + ", id=" + id + ", image=" + image
        + ", name=" + name + ", price=" + price + "]";
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
    final Product other = (Product) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
