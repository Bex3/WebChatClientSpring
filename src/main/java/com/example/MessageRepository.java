package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bearden-tellez on 9/25/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
    ArrayList<Message> findByUser(User user);
}
