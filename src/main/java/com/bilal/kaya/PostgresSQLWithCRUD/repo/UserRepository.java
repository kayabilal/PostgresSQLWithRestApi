package com.bilal.kaya.PostgresSQLWithCRUD.repo;

import com.bilal.kaya.PostgresSQLWithCRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
