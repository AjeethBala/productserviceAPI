package dev.aji.productservice.controllers;

import dev.aji.productservice.models.Category;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping()
    public String getAllProducts(){
        return "All products";
    }
    @GetMapping("{id}")
    public String getProductById(@PathVariable("id") Long id){
        return  "Here is the product with id "+id;
//        return  id;
    }
    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id){

    }

    @PostMapping()
    public void createProduct(){

    }
}
