package com.example.pattern.service.ServiceImp;

import com.example.pattern.persistence.entity.User;
import com.example.pattern.persistence.repository.UserRepository;
import com.example.pattern.service.Filters.Filter;
import com.example.pattern.service.FiltersService;
import com.example.pattern.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    private FiltersService filtersService;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository){this.userRepository =userRepository;}

    public User getUserDtoById(final Long id){
        return userRepository.findFirstById(id);
    }

    public User getUserFromLastName(final String lastName) {
        return userRepository.findByLastname(lastName);
    }

    public List<User> getListOfUsers(final Filter filter){
        return filtersService.filteringByUser(filter);
    }
}
