package com.iblazhchuk.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iblazhchuk.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonJacksonConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());
    // thread-safe
    private ObjectMapper objectMapper = new ObjectMapper();

    public Movie parseMovie(String json) {
        log.info("Start parsing Movie from json {}", json);
        long startTime = System.currentTimeMillis();
        Movie movie = parseValue(json, Movie.class);
        long time = System.currentTimeMillis() - startTime;
        log.info("Movie {} is received. It took {} ms", movie, time);
        return movie;
    }

    private <T> T parseValue(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
