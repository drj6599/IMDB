package dev.dheeraj.IMDB.controller;

import dev.dheeraj.IMDB.dto.ActorDto;
import dev.dheeraj.IMDB.model.Actor;
import dev.dheeraj.IMDB.model.Movie;
import dev.dheeraj.IMDB.model.constant.Gender;
import dev.dheeraj.IMDB.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ActorController {
    @Autowired
    private ActorService actorService;

    @PostMapping("/addActor")
    public ResponseEntity createActor(@RequestBody ActorDto actorDto)
    {
        Actor actor = new Actor();
        actor.setName(actorDto.getName());
        actor.setGender(Gender.valueOf(actorDto.getGender()));
        actor.setCreatedAt(LocalDateTime.now());
        actor.setAge(actorDto.getAge());
        actor.setYearOfBirth(actorDto.getYearOfBirth());
        actor.setMonthOfBirth(actorDto.getMonthOfBirth());
        actorService.saveActor(actor);
        return ResponseEntity.ok(actor);
    }

}
