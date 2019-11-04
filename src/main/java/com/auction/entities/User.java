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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String firstName;

	private String lastName;

	private String email;

	private String adress;

	@OneToMany(mappedBy="user",  cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Bid> bids;
}
