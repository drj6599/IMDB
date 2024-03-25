package dev.dheeraj.IMDB.service;

import dev.dheeraj.IMDB.model.Actor;
import dev.dheeraj.IMDB.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;


    public Actor getActorByName(String name) {
        return actorRepository.findActorByName(name);
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor getActorById(int actorId)
    {
        return actorRepository.findById(actorId);
    }
}
