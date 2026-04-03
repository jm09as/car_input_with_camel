package hu.queue.model;

import hu.queue.main.Cars;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "american_car")
public class AmericanCarEntity extends BaseCarEntity {

    @Override
    public void from(Car car) {
        this.name = car.getName();
        this.brand = car.getBrand();
        this.type = car.getType();
        this.horsepower = car.getHorsepower();
        this.weight = car.getWeight();
        this.withExtras = car.isWithExtras();
        this.nickname = car.getNickname();
    }

    @Override
    public Cars getType() {
        return Cars.AMERICAN_CARS;
    }

}
