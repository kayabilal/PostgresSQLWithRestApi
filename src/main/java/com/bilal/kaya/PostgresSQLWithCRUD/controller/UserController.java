package com.bilal.kaya.PostgresSQLWithCRUD.controller;

import com.bilal.kaya.PostgresSQLWithCRUD.dto.UserDto;
import com.bilal.kaya.PostgresSQLWithCRUD.entity.User;
import com.bilal.kaya.PostgresSQLWithCRUD.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> create (@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

}
