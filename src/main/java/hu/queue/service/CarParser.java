package hu.queue.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.queue.main.Parser;
import hu.queue.model.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Message;

@Slf4j
@ApplicationScoped
public class CarParser implements Parser {

    @Override
    public Car parseCarObject(Message message) throws NotFoundException {
        var carText = message.getBody(String.class);
        try {
            var mapper = new ObjectMapper();
            return mapper.readValue(carText, Car.class);
        } catch (JsonProcessingException e) {
            log.error("Failed to convert to Car class! raw text={}", carText);
            throw new NotFoundException("Failed to convert to Car class! ");
        }
    }
}
