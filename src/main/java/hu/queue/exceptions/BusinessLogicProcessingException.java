package hu.queue.exceptions;

public class BusinessLogicProcessingException extends RuntimeException {

    public BusinessLogicProcessingException(Exception e) {
        super(e);
    }

    public BusinessLogicProcessingException(String message) {
        super(message);
    }

}
