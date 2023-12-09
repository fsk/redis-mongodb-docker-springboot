package com.fsk.redispoc.controller;

import com.fsk.redispoc.model.Post;
import com.fsk.redispoc.model.Writer;
import com.fsk.redispoc.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/writer")
@RestController
@RequiredArgsConstructor
public class WriterController {

    private final WriterService writerService;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @PostMapping("/add-writer")
    public ResponseEntity<Writer> addPost(@RequestBody Writer writer) {
        LOG.info("Saving Writer");
        return ResponseEntity.ok().body(writerService.addWriter(writer));
    }

    @GetMapping("/get-writer-by-id/{id}")
    public ResponseEntity<Writer> getWriterById(@PathVariable("id") String id) {
        LOG.info("Getting Writer with Id : {} ", id);
        return  ResponseEntity.ok().body(writerService.getWriterById(id));
    }

    @GetMapping("/get-all-writers")
    public ResponseEntity<List<Writer>> getAllWriters() {
        LOG.info("Getting all Writers");
        return  ResponseEntity.ok().body(writerService.getAllWriters());
    }

}
