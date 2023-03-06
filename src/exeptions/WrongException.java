package exeptions;

public class WrongException extends DAOException {
    public WrongException(String message){
        super(message);
    }
}
