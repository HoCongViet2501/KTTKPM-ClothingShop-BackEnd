package com.se.backend.ecommerceapp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    
    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

	public Brand(Long id, String name, String description, String phoneNumber, String address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setId(Long id) {
		this.id = id;
	}

	
    
    
}
