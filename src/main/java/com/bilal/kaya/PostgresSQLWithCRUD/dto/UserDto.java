package com.bilal.kaya.PostgresSQLWithCRUD.dto;

import com.bilal.kaya.PostgresSQLWithCRUD.entity.Address;
import lombok.Data;

import javax.persistence.*;

import java.util.List;
@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private List<Address> addresses;
}
