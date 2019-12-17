package com.ascpm.demo.mongo.repository;

import com.ascpm.demo.mongo.document.DemoDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DemoRepository extends ReactiveMongoRepository<DemoDocument, String> {
}
