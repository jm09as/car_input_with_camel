package hu.queue.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private int id;
    private String name;
    private String brand;
    private String type;
    private int horsepower;
    private int weight;
    private boolean withExtras;
    private String nickname;
    private String messageId;

}

