package hu.queue.camelprocess;

import hu.queue.exceptions.BusinessLogicProcessingException;
import hu.queue.ibmmq.MainApplication;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

@Slf4j
@ApplicationScoped
public class CarJsonParserProcessor implements Processor {

    @Inject
    MainApplication mainApplication;

    @Override
    public void process(Exchange exchange) {
        try {
            Message message = exchange.getIn();
            String messageId = exchange.getIn().getMessageId();
            log.info("message id={}", messageId);
            mainApplication.run(message, messageId);
        } catch (Exception e) {
            throw new BusinessLogicProcessingException("message: " + e.getMessage());
        }
    }

}
