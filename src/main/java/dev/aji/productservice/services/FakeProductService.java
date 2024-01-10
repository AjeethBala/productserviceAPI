package dev.aji.productservice.services;

import dev.aji.productservice.thirdPartyClients.FakeStore.dtos.FakeStoreProductDto;
import dev.aji.productservice.dtos.GenericProductDto;
import dev.aji.productservice.exceptions.NotFoundException;
import dev.aji.productservice.thirdPartyClients.FakeStore.FakeStoreProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Primary
@Service("FakeProductService")
public class FakeProductService implements ProductService{
    private FakeStoreProductClient fakeStoreProductClient;

    @Autowired
    public FakeProductService(FakeStoreProductClient fakeStoreProductClient){
        this.fakeStoreProductClient=fakeStoreProductClient;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
//        System.out.println("@qualifier test calling fake product service");

        return convertFakeStoreDtoToGenericDto(fakeStoreProductClient.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto ProductDto) {
        return convertFakeStoreDtoToGenericDto(fakeStoreProductClient.createProduct(ProductDto));
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return  convertFakeStoreDtoToGenericDto(fakeStoreProductClient.deleteProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos=fakeStoreProductClient.getAllProducts();
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
