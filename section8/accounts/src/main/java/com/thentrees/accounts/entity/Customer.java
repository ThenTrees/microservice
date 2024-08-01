package com.thentrees.accounts.entity;

/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:33
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="Customers")
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customerId;

    private String name;

    private String email;

    @Column(name="mobile_number")
    private String mobileNumber;
}
