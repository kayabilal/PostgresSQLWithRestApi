package com.bilal.kaya.PostgresSQLWithCRUD.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {


    @Id
    @SequenceGenerator(name = "seq_user",allocationSize = 1)
    @GeneratedValue(generator = "seq_user",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;

    @OneToMany
    @JoinColumn(name="user_address_id")
    private List<Address> addresses;
}
