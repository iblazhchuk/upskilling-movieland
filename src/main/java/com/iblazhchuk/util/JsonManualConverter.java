package com.iblazhchuk.util;

import com.iblazhchuk.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JsonManualConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String COMMA_SEPARATOR = ",";
    private static final String COLON_SEPARATOR = ":";

    public String toJson(Movie movie) {
        log.info("Start converting movie {} to json", movie);
        StringBuilder json = new StringBuilder("{");
        String[] cityFieldNames = {"id", "name_russian", "name_native","years","description","rating","price","picture_path", "countries","gentries"};
        Object[] movieFields = {movie.getId(), movie.getNameRussian(), movie.getNameNative(),
                movie.getYear().getYear(), movie.getDescription(), movie.getRating(), movie.getPrice(),
                movie.getPicturePath(), movie.getCountries(), movie.getGentries()};
        for (int i = 0; i < cityFieldNames.length; i++) {
            json.append(surroundByQuotes(cityFieldNames[i]));
            json.append(COLON_SEPARATOR);
            json.append(surroundByQuotes(movieFields[i]));
            if (i != cityFieldNames.length - 1) {
                json.append(COMMA_SEPARATOR);
            }
        }
        json.append("}");
        log.info("Receiving movie as json {}", json);
        return json.toString();
    }

    private String surroundByQuotes(Object value) {
        return "\"" + value + "\"";
    }
}
