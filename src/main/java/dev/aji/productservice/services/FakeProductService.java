package dev.aji.productservice.services;

import dev.aji.productservice.dtos.FakeStoreProductDto;
import dev.aji.productservice.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeProductService")
public class FakeProductService implements ProductService{
    RestTemplateBuilder restTemplateBuilder;
    String productURl="https://fakestoreapi.com/products/{id}";
    String requestProductUrl="https://fakestoreapi.com/products";
    @Autowired
    public  void FakeProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
//        System.out.println("@qualifier test calling fake product service");
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response
                =restTemplate.getForEntity(productURl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        GenericProductDto genericProductDtos=convertFakeStoreDtoToGenericDto(fakeStoreProductDto);

        return genericProductDtos;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate
                .postForEntity(
                        requestProductUrl,
                        genericProductDto,
                        FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        GenericProductDto genericProductDtos=convertFakeStoreDtoToGenericDto(fakeStoreProductDto);

        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate
                .exchange(productURl, HttpMethod.DELETE,null,FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        GenericProductDto genericProductDtos=convertFakeStoreDtoToGenericDto(fakeStoreProductDto);

        return genericProductDtos;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=restTemplate
                .getForEntity(requestProductUrl, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos=response.getBody();

        List<GenericProductDto> genericProductDtos=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos ){
            GenericProductDto genericProductDto=convertFakeStoreDtoToGenericDto(fakeStoreProductDto);
            genericProductDtos.add(genericProductDto);

        }

        return genericProductDtos;
    }

    public GenericProductDto convertFakeStoreDtoToGenericDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDesc(fakeStoreProductDto.getDesc());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());

        return  genericProductDto;

    }

}
