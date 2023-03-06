package dao;

import exeptions.*;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<E> {

    void create(E e) throws EmptyException, ExistException, UnableCloseException, SQLException, UnableException;
    void delete(Long id) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException;
    void update(E e) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException;
    List<E> list() throws UnableCloseException, SQLException, UnableException;
    E search(Long id) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException;
}