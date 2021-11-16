package com.github.olvrti.crispy.resources;

import java.net.URI;
import java.util.List;

import com.github.olvrti.crispy.domain.Product;
import com.github.olvrti.crispy.services.ProductService;

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
@RequestMapping(value = "/api/products")
public class ProductResource {
  @Autowired
  private ProductService service;

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    final List<Product> products = service.findAll();
    return ResponseEntity.ok().body(products);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> find(@PathVariable final Integer id) {
    final Product product = service.find(id);
    return ResponseEntity.ok().body(product);
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody final Product productData) {
    final Product product = service.create(productData);
    final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
        .toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@PathVariable final Integer id, @RequestBody final Product productData) {
    productData.setId(id);
    service.update(productData);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable final Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
