package dev.aji.productservice.services;

import dev.aji.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("SelfProductService")
public class SelfProductService implements ProductService
{
    @Override
    public GenericProductDto getProductById(Long id) {
        System.out.println("@qualifier test calling self product service");
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }
}
