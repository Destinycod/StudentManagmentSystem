package service;

import dao.StudentDAOH2Impl;
import entities.Student;
import exeptions.*;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IService<Student>{

    @Override
    public void create(Student student) throws EmptyFieldException, EntityAlreadyExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        StudentDAOH2Impl StudentDAOH2Impl = new StudentDAOH2Impl();
        try {
            StudentDAOH2Impl.create(student);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (ExistException e){
            throw new EntityAlreadyExistException("The Student already exist");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        } catch (UnableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        StudentDAOH2Impl StudentDAOH2Impl = new StudentDAOH2Impl();
        try {
            StudentDAOH2Impl.delete(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The Student does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public void update(Student student) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        StudentDAOH2Impl StudentDAOH2Impl = new StudentDAOH2Impl();
        try {
            StudentDAOH2Impl.update(student);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The Student does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public List<Student> list() throws UnableConnectionException, UnableCloseConnectionException, OperationException {
        StudentDAOH2Impl StudentDAOH2Impl = new StudentDAOH2Impl();
        try {
            return StudentDAOH2Impl.list();
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public Student search(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        StudentDAOH2Impl StudentDAOH2Impl = new StudentDAOH2Impl();
        try {
            return StudentDAOH2Impl.search(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The student does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

}
