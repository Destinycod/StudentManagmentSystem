package service;

import dao.TeacherDAOH2Impl;
import entities.Teacher;
import exeptions.*;

import java.sql.SQLException;
import java.util.List;

public class TeacherService implements IService<Teacher> {

    @Override
    public void create(Teacher teacher) throws EmptyFieldException, EntityAlreadyExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        TeacherDAOH2Impl teacherDAOH2 = new TeacherDAOH2Impl();
        try {
            teacherDAOH2.create(teacher);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (ExistException e){
            throw new EntityAlreadyExistException("The Teacher already exist");
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
        TeacherDAOH2Impl teacherDAOH2 = new TeacherDAOH2Impl();
        try {
            teacherDAOH2.delete(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The Teacher does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public void update(Teacher teacher) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        TeacherDAOH2Impl teacherDAOH2 = new TeacherDAOH2Impl();
        try {
            teacherDAOH2.update(teacher);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The Teacher does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public List<Teacher> list() throws UnableConnectionException, UnableCloseConnectionException, OperationException {
        TeacherDAOH2Impl teacherDAOH2 = new TeacherDAOH2Impl();
        try {
            return teacherDAOH2.list();
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public Teacher search(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        TeacherDAOH2Impl teacherDAOH2 = new TeacherDAOH2Impl();
        try {
            return teacherDAOH2.search(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The Teacher does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }
}
