package hu.queue.repository;

import hu.queue.main.BaseCarRepository;
import hu.queue.model.AmericanCarEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AmericanCarRepository implements BaseCarRepository<AmericanCarEntity> {
}
