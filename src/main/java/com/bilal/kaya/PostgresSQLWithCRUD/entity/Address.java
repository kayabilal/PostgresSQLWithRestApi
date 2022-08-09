package com.bilal.kaya.PostgresSQLWithCRUD.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user_address")
@Data
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user_address",allocationSize = 1)
    @GeneratedValue(generator = "seq_user_address",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String address;
    @Enumerated
    private AddressType addressType;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private User users;


    public enum AddressType{
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER;
    }

}
