package hu.queue.main;

import hu.queue.model.Car;
import jakarta.ws.rs.NotFoundException;
import org.apache.camel.Message;

public interface Parser {

    Car parseCarObject(Message message) throws NotFoundException;
}
