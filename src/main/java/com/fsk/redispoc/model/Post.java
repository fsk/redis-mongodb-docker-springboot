package com.fsk.redispoc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Data
public class Post implements Serializable {

    @Id
    private String id;
    private String title;
    private String content;
    @DBRef
    private Writer writer;
}
