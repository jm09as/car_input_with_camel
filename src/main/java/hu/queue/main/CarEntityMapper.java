package hu.queue.main;

import hu.queue.model.BaseCarEntity;
import hu.queue.model.Car;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface CarEntityMapper {

    Cars supports();

    void mapAndInsert(Car car);

}
