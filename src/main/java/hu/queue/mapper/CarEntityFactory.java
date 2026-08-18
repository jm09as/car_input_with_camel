package hu.queue.mapper;

import hu.queue.main.CarEntityMapper;
import hu.queue.main.Cars;
import hu.queue.model.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
public class CarEntityFactory {

    private Map<Cars, CarEntityMapper> mappers;

    @Inject
    private Instance<CarEntityMapper> carMappers;

    public void handle() {
        log.info("list of mapper={}", carMappers);
        this.mappers = carMappers.stream().collect(Collectors.toMap(CarEntityMapper::supports, Function.identity()));
    }

    public void createInsert(Car car, Cars origin) {
        CarEntityMapper orDefault = mappers.getOrDefault(origin, mappers.get(Cars.OTHER));
        log.info("star with car mapper {}", orDefault);
        orDefault.mapAndInsert(car);
    }

}
