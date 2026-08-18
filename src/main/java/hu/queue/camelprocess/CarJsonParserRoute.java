package hu.queue.camelprocess;

import hu.queue.exceptions.BusinessLogicProcessingException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CarJsonParserRoute extends RouteBuilder {

    private final CarJsonParserProcessor carJsonParserProcessor;

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
