package dev.aji.productservice.thirdPartyClients.FakeStore.dtos;

import dev.aji.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    public Long id;
    private String title;
    private  String desc;
    private  String image;
    private String category;
    private double price;
}
