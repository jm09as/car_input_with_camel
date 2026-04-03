package hu.queue.mapper;

import hu.queue.main.CarEntityMapper;
import hu.queue.main.Cars;
import hu.queue.model.Car;
import hu.queue.model.ItalyCarEntity;
import hu.queue.repository.ItalyCarRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ItalyCarMapper implements CarEntityMapper {

    @Inject
    ItalyCarRepository italyCarRepository;

    @Override
    public Cars supports() {
        return Cars.ITALY_CARS;
    }

    @Override
    public void mapAndInsert(Car car) {
        ItalyCarEntity e = new ItalyCarEntity();
        e.from(car);
        log.info("entity to insert into db={} and founded car={}", e, car);
        italyCarRepository.persist(e);
    }

}
