package com.ascpm.demo.mongo.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("demo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoDocument {

    @Id
    private String id;
    private String name;
}
