package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository repository;
  private final CategoryRepository categoryRepository;

  public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
    this.repository = repository;
    this.categoryRepository = categoryRepository;
  }

  @Transactional
  public ProductDTO insert(ProductDTO dto) {
    // Vamos criar uma entidade a partir do DTO
    Product entity = new Product();
    this.copyDtoToEntity(dto, entity);

    // Vamos fazer um loop sobre a lista de categorias
    for (CategoryDTO catDto : dto.getCategories()) {
      // Podemos criar categorias a partir do DTO (1) ou buscar categorias existentes no banco (2) e fazer a relação

      // 1º Criando categorias a partir do DTO
      // Category cat = new Category(); --> Instanciando uma Entidade categoria
      // this.copyDtoToEntity(catDto, cat); --> Setando propriedades da Entidade categoria

      // 2º Buscando categorias no banco de dados
      Category cat = this.categoryRepository.getReferenceById(catDto.getId()); // Buscando a categoria no banco de dados
      entity.getCategories().add(cat); // Adicionando a categoria na lista de categorias da Entidade produto
    }

    // Salvamos a Entidade no banco de dados
    this.repository.save(entity);

    // O DTO possui um construtor que recebe a Entidade produto
    return new ProductDTO(entity);
  }

  private void copyDtoToEntity(ProductDTO dto, Product entity) {
    entity.setName(dto.getName());
    entity.setPrice(dto.getPrice());
  }

  private void copyDtoToEntity(CategoryDTO dto, Category entity) {
    entity.setId(dto.getId());
    entity.setName(dto.getName());
  }
}
