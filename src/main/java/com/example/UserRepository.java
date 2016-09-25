package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by bearden-tellez on 9/24/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findFirstByName(String name);
}
