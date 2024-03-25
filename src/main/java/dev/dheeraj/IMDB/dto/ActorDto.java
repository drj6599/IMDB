package dev.dheeraj.IMDB.dto;

import dev.dheeraj.IMDB.model.Movie;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
public class ActorDto {
    private String name;
    private int age;
    private int yearOfBirth;
    private int monthOfBirth;
    private String gender;
}
