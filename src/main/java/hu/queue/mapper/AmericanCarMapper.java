package hu.queue.mapper;

import hu.queue.main.CarEntityMapper;
import hu.queue.main.Cars;
import hu.queue.model.AmericanCarEntity;
import hu.queue.model.Car;
import hu.queue.repository.AmericanCarRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class AmericanCarMapper implements CarEntityMapper {

    @Inject
    AmericanCarRepository americanCarRepository;

    @Override
    public Cars supports() {
        return Cars.AMERICAN_CARS;
    }

    @Override
    public void mapAndInsert(Car car) {
        AmericanCarEntity e = new AmericanCarEntity();
        e.from(car);
        log.info("entity to insert into db={} and founded car={}", e, car);
        americanCarRepository.persist(e);
    }

}
