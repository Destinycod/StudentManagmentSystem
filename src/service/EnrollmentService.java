package service;

import dao.EnrollmentDAOH2Impl;
import entities.Course;
import entities.Enrollment;
import exeptions.*;

import java.sql.SQLException;
import java.util.List;

public class EnrollmentService implements IService<Enrollment> {

    @Override
    public void create(Enrollment enrollment) throws EmptyFieldException, EntityAlreadyExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        EnrollmentDAOH2Impl enrollmentDAOH2 = new EnrollmentDAOH2Impl();
        CourseService courseService = new CourseService();
        //TODO CHECK
        if( (enrollment.getStudent().getEnrollments().size() < 4) &&
                (enrollment.getCourse().getEnrollments().size() <= enrollment.getCourse().getQuota())) {
            try {
                enrollmentDAOH2.create(enrollment);/*
                Course course = courseService.search(enrollment.getCourse().getId());
                System.out.println("Curso: " + course);
                course.getEnrollments().add(enrollment.getId());
                System.out.println("Curso enroll agregado: " + course);*/

                enrollment.getStudent().getEnrollments().add(enrollment);
                System.out.println("Student Enrollment: " + enrollment.getStudent().getEnrollments().size());
                enrollment.getCourse().getEnrollments().add(enrollment.getId());
                System.out.println("Course Enrollment: " + enrollment.getCourse().getEnrollments().size()); //TODO
                //System.out.println("Course Enrollment: " + course.getEnrollments().size()); //TODO
            } catch (EmptyException e) {
                throw new EmptyFieldException("There cannot be empty fields");
            } catch (ExistException e) {
                throw new EntityAlreadyExistException("The enrollment already exist");
            } catch (UnableCloseException e) {
                throw new UnableCloseConnectionException("The connection could not be closed");
            } catch (SQLException e) {
                throw new OperationException();
            } catch (UnableException e) {
                e.printStackTrace();
            } /*catch (EntityNotExistException e) {
                e.printStackTrace();
            }*/
        }
    }

    @Override
    public void delete(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        EnrollmentDAOH2Impl enrollmentDAOH2 = new EnrollmentDAOH2Impl();
        try {
            enrollmentDAOH2.delete(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The enrollment does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public void update(Enrollment enrollment) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        EnrollmentDAOH2Impl enrollmentDAOH2 = new EnrollmentDAOH2Impl();
        try {
            enrollmentDAOH2.update(enrollment);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The enrollment does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public List<Enrollment> list() throws UnableConnectionException, UnableCloseConnectionException, OperationException {
        EnrollmentDAOH2Impl enrollmentDAOH2 = new EnrollmentDAOH2Impl();
        try {
            return enrollmentDAOH2.list();
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public Enrollment search(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        EnrollmentDAOH2Impl enrollmentDAOH2 = new EnrollmentDAOH2Impl();
        try {
            return enrollmentDAOH2.search(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The enrollment does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }
}
