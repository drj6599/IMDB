package dev.dheeraj.IMDB.model;

import dev.dheeraj.IMDB.model.constant.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Actor extends BaseModel{
    private String name;
    private int age;
    private int yearOfBirth;
    private int monthOfBirth;
    @ManyToMany
    private List<Movie> movies;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
