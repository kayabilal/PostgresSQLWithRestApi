package com.bilal.kaya.PostgresSQLWithCRUD.service;

import com.bilal.kaya.PostgresSQLWithCRUD.dto.UserDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    void delete(Long id);
    List<UserDto> getAll();
    Page<UserDto> getAll(Pageable pageable);

}
