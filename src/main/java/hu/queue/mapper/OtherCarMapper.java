package hu.queue.mapper;

import hu.queue.main.CarEntityMapper;
import hu.queue.main.Cars;
import hu.queue.model.Car;
import hu.queue.model.OtherCarEntity;
import hu.queue.repository.OtherCarRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@ApplicationScoped
public class OtherCarMapper implements CarEntityMapper {

    @Inject
    OtherCarRepository otherCarRepository;

    @Override
    public Cars supports() {
        return Cars.OTHER;
    }

    @Override
    public void mapAndInsert(Car car) {
        OtherCarEntity e = new OtherCarEntity();
        e.from(car);
        log.info("entity to insert into db={} and founded car={}", e, car);
        otherCarRepository.persist(e);
    }

}
