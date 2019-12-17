package com.ascpm.demo.mongo.repository;

import com.ascpm.demo.mongo.document.DemoDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DemoRepositoryTest {

    @Autowired
    private DemoRepository repository;

    @Test
    public void saveTest() {
        String id = UUID.randomUUID().toString();
        DemoDocument demoDocument = DemoDocument.builder()
                .id(id)
                .name("demo")
                .build();
        this.repository.insert(demoDocument).block();
        Mono<DemoDocument> demoDocumentMono = this.repository.findById(id);
        StepVerifier
                .create(demoDocumentMono)
                .assertNext(it -> {
                    assertEquals(id, it.getId());
                    assertEquals("demo", it.getName());
                })
                .expectComplete()
                .verify();
    }

}
