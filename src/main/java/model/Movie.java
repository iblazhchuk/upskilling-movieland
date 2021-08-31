package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Movie {
    private long id;
    private String nameRussian;
    private String nameNative;
    private LocalDate year;
    private String description;
    private Double rating;
    private Double price;
    private String picturePath;
    private List<String> countries;
    private List<String> gentries;
}
