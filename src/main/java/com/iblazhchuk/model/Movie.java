package com.iblazhchuk.model;

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
    private LocalDate year;
    private String description;
    private Double rating;
    private Double price;
    private String picturePath;
    private String countries;
    private String gentries;

    public Movie(String nameRussian, String nameNative, LocalDate year, String description, Double rating,
                 Double price, String picturePath, String countries, String gentries) {

        this.nameRussian = nameRussian;
        this.nameNative = nameNative;
        this.year = year;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.picturePath = picturePath;
        this.countries = countries;
        this.gentries = gentries;
    }
}
