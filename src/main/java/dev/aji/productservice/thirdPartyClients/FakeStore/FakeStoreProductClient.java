package dev.aji.productservice.thirdPartyClients.FakeStore;

import dev.aji.productservice.thirdPartyClients.FakeStore.dtos.FakeStoreProductDto;
import dev.aji.productservice.dtos.GenericProductDto;
import dev.aji.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreProductClient {
    RestTemplateBuilder restTemplateBuilder;
    String productURl="https://fakestoreapi.com/products/{id}";
    String requestProductUrl="https://fakestoreapi.com/products";
    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${fakestore.api.baseUrl}") String fakestorebaseUrl,
                                  @Value("${fakestore.api.product}") String fakeStoreProduct){
        this.restTemplateBuilder=restTemplateBuilder;
        this.productURl=fakestorebaseUrl+fakeStoreProduct+"/{id}";
        this.requestProductUrl=fakestorebaseUrl+fakeStoreProduct;
        System.out.println(productURl);
        System.out.println(requestProductUrl);
    }


    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
//        System.out.println("@qualifier test calling fake product service");
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response
                =restTemplate.getForEntity(productURl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        if (fakeStoreProductDto==null){
            throw  new NotFoundException("Product with id "+id+" is  not found");
        }

        return fakeStoreProductDto;
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate
                .postForEntity(
                        requestProductUrl,
                        genericProductDto,
                        FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto=response.getBody();

        return fakeStoreProductDto;
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate
                .exchange(productURl, HttpMethod.DELETE,null,FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto=response.getBody();

        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=restTemplate
                .getForEntity(requestProductUrl, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos=response.getBody();


        return Arrays.asList(fakeStoreProductDtos);
    }
}
