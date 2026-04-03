package hu.queue.ibmmq;

import hu.queue.main.Cars;
import hu.queue.main.Parser;
import hu.queue.mapper.CarEntityFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Message;

import java.util.Arrays;

@Slf4j
@ApplicationScoped
public class MainApplication {

    @Inject
    Parser carParser;

    @Inject
    CarEntityFactory carEntityFactory;

    @Transactional
    public void run(Message message, String messageId) {
        var car = carParser.parseCarObject(message);
        car.setMessageId(messageId);
        log.info("successfully parsed car={}", car);
        Cars foundedCar = Arrays.stream(Cars.values())
                .filter(c -> c.getCars().contains(car.getBrand()))
                .findFirst()
                .orElse(Cars.OTHER);
        log.info("founded car type={}", foundedCar);
        carEntityFactory.handle();
        carEntityFactory.createInsert(car, foundedCar);
    }
}
