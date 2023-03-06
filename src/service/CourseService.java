package service;

import dao.CourseDAOH2Impl;
import entities.Course;
import exeptions.*;

import java.sql.SQLException;
import java.util.List;

public class CourseService implements IService<Course>{
    @Override
    public void create(Course course) throws EmptyFieldException, EntityAlreadyExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        CourseDAOH2Impl courseDAOH2 = new CourseDAOH2Impl();
        try {
            courseDAOH2.create(course);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (ExistException e){
            throw new EntityAlreadyExistException("The Course already exist");
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
        CourseDAOH2Impl courseDAOH2 = new CourseDAOH2Impl();
        try {
            courseDAOH2.delete(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The Course does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public void update(Course course) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        CourseDAOH2Impl courseDAOH2 = new CourseDAOH2Impl();
        try {
            courseDAOH2.update(course);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The Course does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public List<Course> list() throws UnableConnectionException, UnableCloseConnectionException, OperationException {
        CourseDAOH2Impl courseDAOH2 = new CourseDAOH2Impl();
        try {
            return courseDAOH2.list();
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public Course search(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        CourseDAOH2Impl courseDAOH2 = new CourseDAOH2Impl();
        try {
            return courseDAOH2.search(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The Course does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }
}
