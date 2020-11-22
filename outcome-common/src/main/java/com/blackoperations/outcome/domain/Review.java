package com.blackoperations.outcome.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;

    @NotEmpty
    private String name;

//    @Min(0)
//    @Max(5)
    @NotNull
    private Integer score;

    @NotEmpty
    private String description;
}
