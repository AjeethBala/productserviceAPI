package dev.aji.productservice.controllers;

import dev.aji.productservice.dtos.ExceptionDto;
import dev.aji.productservice.dtos.GenericProductDto;
import dev.aji.productservice.exceptions.NotFoundException;
import dev.aji.productservice.models.Category;
import dev.aji.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public void ProductContoller(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
//        return  "Here is the product with id "+id;
        return  productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return  productService.getAllProducts();
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return  productService.createProduct(genericProductDto);

    }
    @DeleteMapping("{id}")
    public  GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);

    }
    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id){

    }
    //This is specific to controller and we use @controller advice for exception anywhere
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
//        return  new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),HttpStatus.NOT_FOUND);
//    }


}
