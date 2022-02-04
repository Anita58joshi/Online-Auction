package com.nepalaya.onlineauction.model;



import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity<User>{

//    ProductID INTEGER PRIMARY KEY,
//    ProductName varchar(255) NOT NULL,
//    ProductCategory varchar(255) NOT NULL references OnlineAuctionDB.Category(CategoryName),
//    ProductDesc varchar(255) NOT NULL,
//    ActualPrice double NOT NULL,
//    Quantity INTEGER NOT NULL,
//    Image varchar(255) NOT NULL,
//    SellerID INTEGER NOT NULL references OnlineAuctionDB.Usertable(UserID)

    @Column(length = 150, name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(length = 150, name = "PRODUCT_CATEGORY")
    private String productCategory;

    @Column(length = 150, name = "PRODUCT_DESCRIPTION", nullable = false)
    private String productDescription;

    @Column(length = 150, name = "ACTUAL_PRICE", nullable = false)
    private Double actualPrice;

    @Column(length = 150, name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(length = 150, name = "IMAGE", nullable = false)
    private String image;


    private Long sellerid;


}
