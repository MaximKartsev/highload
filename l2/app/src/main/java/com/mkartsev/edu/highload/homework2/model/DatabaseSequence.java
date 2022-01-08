package com.mkartsev.edu.highload.homework2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
@Setter
@Getter
@NoArgsConstructor
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;
}