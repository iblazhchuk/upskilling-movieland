package com.iblazhchuk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
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

}
