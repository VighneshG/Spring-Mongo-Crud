package com.spring.mongo.repository;

import com.spring.mongo.Domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
