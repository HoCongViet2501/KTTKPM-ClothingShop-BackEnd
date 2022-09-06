package com.se.backend.ecommerceapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop_owner")
public class ShopOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Column(name = "created_date")
    private Date createdDate;
    
    @Column(name = "updated_date")
    private Date updatedDate;
    
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
    
    @OneToMany(mappedBy = "shopOwner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;
}
