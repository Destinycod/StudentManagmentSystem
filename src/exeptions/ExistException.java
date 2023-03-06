package exeptions;

public class ExistException extends DAOException {

    public ExistException(String message){
        super(message);
    }
}
