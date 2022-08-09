package com.bilal.kaya.PostgresSQLWithCRUD.service.impl;

import com.bilal.kaya.PostgresSQLWithCRUD.dto.UserDto;
import com.bilal.kaya.PostgresSQLWithCRUD.entity.Address;
import com.bilal.kaya.PostgresSQLWithCRUD.entity.User;
import com.bilal.kaya.PostgresSQLWithCRUD.repo.AddressRepository;
import com.bilal.kaya.PostgresSQLWithCRUD.repo.UserRepository;
import com.bilal.kaya.PostgresSQLWithCRUD.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    public UserDto save(UserDto userDto) {
        User user= new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userDb=userRepository.save(user);

        List<Address> liste=new ArrayList<>();
        userDto.getAddresses().forEach(item -> {
            Address adres=new Address();
            adres.setAddress(item.getAddress());
            adres.setAddressType(item.getAddressType());
            adres.setActive(true);
            adres.setUsers(user);
        });
        addressRepository.saveAll(liste);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users=userRepository.findAll();
        List<UserDto> userDtos=new ArrayList<>();

        users.forEach(it -> {
            UserDto userDto=new UserDto();
            userDto.setId(it.getId());
            userDto.setName(it.getName());
            userDto.setSurname(it.getSurname());
            //userDto.setAddresses(it.getAddresses().stream().map(Address::).collect(Collectors.toList()));
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
