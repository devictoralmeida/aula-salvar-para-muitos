package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
  private Long id;
  private String name;
  private Double price;
  private List<CategoryDTO> categories = new ArrayList<>();

  public ProductDTO(Long id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public ProductDTO(Product entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.price = entity.getPrice();

    for (Category category : entity.getCategories()) {
      this.categories.add(new CategoryDTO(category));
    }
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public List<CategoryDTO> getCategories() {
    return this.categories;
  }

  public void setCategories(List<CategoryDTO> categories) {
    this.categories = categories;
  }
}
