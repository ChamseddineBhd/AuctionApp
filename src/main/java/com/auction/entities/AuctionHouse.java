package com.auction.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuctionHouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long auctionHouseId;

	private String name;

	@OneToMany(mappedBy="auctionHouse",  cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Auction> auctions;
}
