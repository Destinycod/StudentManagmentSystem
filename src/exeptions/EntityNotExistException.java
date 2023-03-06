package exeptions;

public class EntityNotExistException extends ServiceException {

    public EntityNotExistException(String message){
        super(message);
    }

}
