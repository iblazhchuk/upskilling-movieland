package com.iblazhchuk.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Review {
    private long id;
    private long filmId;
    private long userId;
    private String textReview;

}

