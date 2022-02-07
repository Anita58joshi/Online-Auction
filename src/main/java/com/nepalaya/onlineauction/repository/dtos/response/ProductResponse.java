package com.nepalaya.onlineauction.repository.dtos.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private String productName;
    private String productCategory;
    private String productDescription;
    private Double actualPrice;
    private Integer quantity;
    private String image;
    private Long sellerId;

}
