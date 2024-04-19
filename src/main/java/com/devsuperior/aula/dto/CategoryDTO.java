package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Category;

public class CategoryDTO {
  private Long id;
  private String name;

  public CategoryDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public CategoryDTO(Category entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
}
