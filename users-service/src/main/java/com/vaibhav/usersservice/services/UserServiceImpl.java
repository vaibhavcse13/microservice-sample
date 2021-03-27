package com.vaibhav.usersservice.services;

import com.vaibhav.usersservice.dto.UserDto;
import com.vaibhav.usersservice.entity.UserEntity;
import com.vaibhav.usersservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDto createUser(UserDto user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        ModelMapper modelMapper =  new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        userRepository.save(userEntity);
        return user;
    }

    @Override
    public String getUserId(String email) {
       UserEntity userEntity =  userRepository.findByEmail(email);
       if (userEntity == null ) throw new UsernameNotFoundException("Email not found");

       return userEntity.getUserId();

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail() , userEntity.getEncryptedPassword() ,
                true ,
                true ,
                true,
                true,
                new ArrayList<>());


    }


}
