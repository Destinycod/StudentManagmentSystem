package service;

import exeptions.*;

import java.util.List;

public interface IService<D> {
    void create(D d) throws EmptyFieldException, EntityAlreadyExistException, UnableConnectionException, UnableCloseConnectionException, OperationException;
    void delete(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException;
    void update(D d) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException;
    List<D> list() throws UnableConnectionException, UnableCloseConnectionException, OperationException;
    D search(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException;
}
