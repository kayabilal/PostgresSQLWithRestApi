package com.bilal.kaya.PostgresSQLWithCRUD.repo;

import com.bilal.kaya.PostgresSQLWithCRUD.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
