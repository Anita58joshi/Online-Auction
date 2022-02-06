package com.nepalaya.onlineauction.model;


import com.nepalaya.onlineauction.model.enums.BidStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BID")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bid extends BaseEntity<User> {
//    BidID INTEGER PRIMARY KEY,
//    BidderID INTEGER NOT NULL references OnlineAuctionDB.Usertable(UserID),
//    BidProductID INTEGER NOT NULL references OnlineAuctionDB.Product(ProductID),
//    BidValue double NOT NULL,
//    Status INTEGER NOT NULL

    @Column(length = 150, name = "BIDDER_ID", nullable = false)
    private Long bidderID;

    @Column(length = 150, name = "BID_PRODDUCT_ID")
    private Long bidProductID;

    @Column(length = 150, name = "BID_VALUE", nullable = false)
    private Double bidValue;

    @Column(name = "BID_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private BidStatus bidStatus;


}
