package com.fsk.redispoc.repository;

import com.fsk.redispoc.model.Writer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WriterRepository extends MongoRepository<Writer, String> {

}
