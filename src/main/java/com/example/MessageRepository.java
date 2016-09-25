package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by bearden-tellez on 9/24/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByUser(User user);
}