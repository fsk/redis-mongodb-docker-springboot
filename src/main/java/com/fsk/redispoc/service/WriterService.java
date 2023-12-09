package com.fsk.redispoc.service;

import com.fsk.redispoc.model.Writer;
import com.fsk.redispoc.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WriterService {

    private final WriterRepository writerRepository;

    public Writer addWriter(Writer writer) {
        return writerRepository.save(writer);
    }

    public Writer getWriterById(String id) {
        return writerRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Writer not found.!"));
    }

    public List<Writer> getAllWriters() {
        return writerRepository.findAll();
    }
}
