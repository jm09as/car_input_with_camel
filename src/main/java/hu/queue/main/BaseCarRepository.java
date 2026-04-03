package hu.queue.main;

import hu.queue.model.BaseCarEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface BaseCarRepository<T extends BaseCarEntity> extends PanacheRepository<T> {
}
