package exeptions;

public class EmptyFieldException extends ServiceException{

    public EmptyFieldException(){

    }
    public EmptyFieldException(String message){
        super(message);

    }
}
