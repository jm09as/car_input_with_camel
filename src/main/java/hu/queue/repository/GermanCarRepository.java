package hu.queue.repository;

import hu.queue.main.BaseCarRepository;
import hu.queue.model.GermanCarEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GermanCarRepository implements BaseCarRepository<GermanCarEntity> {
}
