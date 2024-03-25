package dev.dheeraj.IMDB.repository;

import dev.dheeraj.IMDB.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Integer> {
    Actor findActorByName(String name);
    Actor findById(int actorId);
}
