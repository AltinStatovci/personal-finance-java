package com.example.PersonalFinanceApi.Service.userServicel;

import com.example.PersonalFinanceApi.Dtos.UserDto;
import com.example.PersonalFinanceApi.Repositories.UserRepository;
import com.example.PersonalFinanceApi.mappers.UserMapStructMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapStructMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, UserMapStructMapper mapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void updateUser(Long id, UserDto user) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()){
            throw new RuntimeException("User with id not found "+id);
        }
        var entity = optionalEntity.get();
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setEmail(user.getEmail());
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        entity.setRole(user.getRole());

        repository.save(entity);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);

    }

    @Override
    public UserDto getUserById(Long id) {
        var entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new RuntimeException("User with id not found " + id);
        }
        var dto = mapper.toDto(entity.get());
        return dto;
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public boolean checkPassword(Long id, String rawPassword) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new RuntimeException("User with id not found " + id);
        }
        var entity = optionalEntity.get();
        return passwordEncoder.matches(rawPassword, entity.getPassword());
    }
}

