package exeptions;

public class UnableConnectionException extends ServiceException{
    public UnableConnectionException(String message){
        super(message);
    }
}
