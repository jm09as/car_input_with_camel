package hu.queue.model;

import hu.queue.main.CarEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.ToString;

@ToString
@MappedSuperclass
public abstract class BaseCarEntity implements CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String brand;
    public String type;
    public int horsepower;
    public int weight;
    public boolean withExtras;
    public String nickname;

    public abstract void from(Car car);
}

