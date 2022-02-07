package com.nepalaya.onlineauction.repository.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class ProductRequest implements Serializable {

    @NotEmpty(message = "productName is required!")
    private String productName;

    @NotEmpty
    private String productCategory;

    @NotEmpty(message = "Description is required!")
    private String productDescription;

    @NotNull
    private Double actualPrice;

    @NotNull
    private Integer quantity;

    @NotEmpty
    private String image;

    @NotNull
    private Long sellerId;

}
