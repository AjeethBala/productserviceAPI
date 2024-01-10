package dev.aji.productservice.services;

import dev.aji.productservice.dtos.GenericProductDto;
import dev.aji.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public  GenericProductDto createProduct(GenericProductDto genericProductDto);

    public  GenericProductDto deleteProductById(Long id);
    public List<GenericProductDto> getAllProducts();
}
