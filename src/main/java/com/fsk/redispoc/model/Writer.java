package com.fsk.redispoc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
@Data
public class Writer implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;
    private String name;
    private String surname;
    @DBRef
    @JsonIgnore
    private List<Post> postList;

}
