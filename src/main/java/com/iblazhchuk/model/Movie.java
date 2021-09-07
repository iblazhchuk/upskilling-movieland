package com.iblazhchuk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Movie {
    private long id;
    private String nameRussian;
    private String nameNative;
    @JsonFormat(pattern = "yyyy")
    private LocalDate year;
    private Double rating;
    private Double price;
    private String picturePath;


    public Movie(String nameRussian, String nameNative, LocalDate year, Double rating,
                 Double price, String picturePath) {

        this.nameRussian = nameRussian;
        this.nameNative = nameNative;
        this.year = year;
        this.rating = rating;
        this.price = price;
        this.picturePath = picturePath;
    }
}
