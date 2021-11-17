package com.github.olvrti.crispy.services;

import java.util.List;
import java.util.Optional;

import com.github.olvrti.crispy.domain.Product;
import com.github.olvrti.crispy.repositories.ProductRepository;
import com.github.olvrti.crispy.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;

  public List<Product> findAll() {
    return repository.findAll();
  }

  public Product find(final Integer id) {
    final Optional<Product> product = repository.findById(id);
    return product.orElseThrow(() -> new ObjectNotFoundException(String.format("Product not found: %d", id)));
  }

  public Product create(final Product product) {
    return repository.save(product);
  }

  public Product update(final Product product) {
    find(product.getId());
    return repository.save(product);
  }

  public void delete(final Integer id) {
    find(id);
    repository.deleteById(id);
  }

}
