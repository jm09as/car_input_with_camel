package hu.queue.camelprocess;

import hu.queue.exceptions.BusinessLogicProcessingException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class CarJsonParserRoute extends RouteBuilder {

    @Inject
    CarJsonParserProcessor carJsonParserProcessor;

    @Override
    public void configure() {
        onException(BusinessLogicProcessingException.class)
                .handled(true)
                .log("❌ Business error: ${exception.message}")
                .to("jms:queue:QUEUE.CAR.DLQ");

        from("jms:queue:QUEUE.CAR.IN.001")
                .routeId("queue1-route")
                .log("📥 Message arrived: ${body}")
                .process(carJsonParserProcessor);
    }
}
