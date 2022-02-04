package com.nepalaya.onlineauction.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity<User> {
//    CategoryID INTEGER NOT NULL UNIQUE,
//    CategoryName varchar(255) NOT NULL,
//    CategoryDesc varchar(255) NOT NULL,
//    PRIMARY KEY(CategoryName)

    @Id
    @GeneratedValue
    @Column(length = 150, name = "CATEGORY_NAME", nullable = false)
    private String categoryName;

    @Column(length = 150, name = "CATEGORY_DESCRIPTION", nullable = false)
    private String categoryDescription;





}
