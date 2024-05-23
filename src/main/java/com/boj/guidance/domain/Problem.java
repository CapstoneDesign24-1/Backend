package com.boj.guidance.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Problem {

    @Id
    private Integer problemId;
    private String title;
    private String link;
    private int level;
    private Long numberOfSolved;
    private float avgTry;

}
