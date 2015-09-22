package com.ipowertec.abigear.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ipowertec.abigear.domain.User;
import com.ipowertec.abigear.domain.UserCreateForm;

@Service
public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
