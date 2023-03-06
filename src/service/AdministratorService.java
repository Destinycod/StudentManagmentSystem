package service;

import dao.AdministratorDAOH2Impl;
import entities.Administrator;
import exeptions.*;

import java.sql.SQLException;
import java.util.List;

public class AdministratorService implements IService<Administrator> {

    @Override
    public void create(Administrator administrator) throws EmptyFieldException, EntityAlreadyExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        AdministratorDAOH2Impl administratorDAOH2 = new AdministratorDAOH2Impl();
        try {
            administratorDAOH2.create(administrator);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (ExistException e){
            throw new EntityAlreadyExistException("The Administrator already exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public void delete(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        AdministratorDAOH2Impl administratorDAOH2 = new AdministratorDAOH2Impl();
        try {
            administratorDAOH2.delete(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e) {
            throw new EntityNotExistException("There Administrator does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public void update(Administrator administrator) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        AdministratorDAOH2Impl administratorDAOH2 = new AdministratorDAOH2Impl();
        try {
            administratorDAOH2.update(administrator);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e) {
            throw new EntityNotExistException("There Administrator does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public List<Administrator> list() throws UnableConnectionException, UnableCloseConnectionException, OperationException {
        AdministratorDAOH2Impl administratorDAOH2 = new AdministratorDAOH2Impl();
        try {
            return administratorDAOH2.list();
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public Administrator search(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        AdministratorDAOH2Impl administratorDAOH2 = new AdministratorDAOH2Impl();
        try {
            return administratorDAOH2.search(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e) {
            throw new EntityNotExistException("There Administrator does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

}
