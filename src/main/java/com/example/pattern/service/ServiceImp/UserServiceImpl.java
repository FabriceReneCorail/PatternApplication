package com.example.pattern.service.ServiceImp;

import com.example.pattern.api.Dto.UserRequestDto;
import com.example.pattern.persistence.entity.User;
import com.example.pattern.persistence.repository.UserRepository;
import com.example.pattern.service.Filters.Filter;
import com.example.pattern.service.FiltersService;
import com.example.pattern.service.UserService;
import com.example.pattern.service.mapper.Mapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private Mapper mapper;
    private FiltersService filtersService;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, FiltersService filtersService, Mapper mapper){
        this.userRepository = userRepository;
        this.filtersService = filtersService;
        this.mapper = mapper;
    }

    public User getUserDtoById(final Long id){
        return userRepository.findFirstById(id);
    }

    public UserRequestDto getUserById(User user){
        return mapper.mapEntityToDto(user);
    }

    public User getUserFromLastName(final String lastName) {
        return userRepository.findByLastname(lastName);
    }

    public List<User> getListOfUsers(final Filter filter){
        return filtersService.filteringByUser(filter);
    }
    public void addNewUser(final UserRequestDto user) {
        final var result = mapper.mapDtoToEntity(user);
        userRepository.save(result);
    }
}
