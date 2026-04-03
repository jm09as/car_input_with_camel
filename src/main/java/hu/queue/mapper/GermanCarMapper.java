package hu.queue.mapper;

import hu.queue.main.CarEntityMapper;
import hu.queue.main.Cars;
import hu.queue.model.Car;
import hu.queue.model.GermanCarEntity;
import hu.queue.repository.GermanCarRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class GermanCarMapper implements CarEntityMapper {

    @Inject
    GermanCarRepository germanCarRepository;

    @Override
    public Cars supports() {
        return Cars.GERMAN_CARS;
    }

    @Override
    public void mapAndInsert(Car car) {
        GermanCarEntity entity = new GermanCarEntity();
        entity.from(car);
        log.info("entity to insert into db={} and founded car={}", entity, car);
        germanCarRepository.persist(entity);
    }

}
