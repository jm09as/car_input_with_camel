package hu.queue.mapper;

import hu.queue.main.CarEntityMapper;
import hu.queue.main.Cars;
import hu.queue.model.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
public class CarEntityFactory {

    private Map<Cars, CarEntityMapper> mappers;

    @Inject
    AmericanCarMapper americanCarMapper;

    @Inject
    GermanCarMapper germanCarMapper;

    @Inject
    ItalyCarMapper italyCarMapper;

    @Inject
    OtherCarMapper otherCarMapper;

    public void handle() {
        List<CarEntityMapper> mapperList = List.of(americanCarMapper, germanCarMapper, italyCarMapper, otherCarMapper);
        log.info("list of mapper={}", mapperList);
        this.mappers = mapperList.stream().collect(Collectors.toMap(CarEntityMapper::supports, Function.identity()));
    }

    public void createInsert(Car car, Cars origin) {
        CarEntityMapper orDefault = mappers.getOrDefault(origin, mappers.get(Cars.OTHER));
        log.info("star with car mapper {}", orDefault);
        orDefault.mapAndInsert(car);
    }

}
