package com.auction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long auctionId;

	private String name;

	private String description;

	private LocalDateTime start;

	private LocalDateTime end;

	private double price;

	private double currentPrice;

	@ManyToOne
	@JoinColumn(name="auctionHouse")
	@JsonIgnore
	private AuctionHouse auctionHouse;

	@OneToMany(mappedBy="auction")
	@JsonIgnore
	private List<Bid> bids;
}
