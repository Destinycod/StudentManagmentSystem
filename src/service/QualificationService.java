package service;

import dao.QualificationDAOH2Impl;
import entities.Qualification;
import exeptions.*;

import java.sql.SQLException;
import java.util.List;

public class QualificationService implements IService<Qualification> {
    //TODO CHECK. VALIDACIONES DEBERIAN ESTAR EN UI
    @Override
    public void create(Qualification qualification) throws EmptyFieldException, EntityAlreadyExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        QualificationDAOH2Impl qualificationDAOH2 = new QualificationDAOH2Impl();
        if( (qualification.getQualification() > 0 && qualification.getQualification() < 11)
            && (qualification.getCourse().getMidtermsRequired()+1 < qualification.getCourse().getQualifications().size())){
            try {
                qualificationDAOH2.create(qualification);
            } catch (EmptyException e) {
                throw new EmptyFieldException("There cannot be empty fields");
            } catch (ExistException e) {
                throw new EntityAlreadyExistException("The qualification already exist");
            } catch (UnableCloseException e) {
                throw new UnableCloseConnectionException("The connection could not be closed");
            } catch (SQLException e) {
                throw new OperationException();
            } catch (UnableException e) {
                e.printStackTrace();
            }
        } else {
            //throw new Exception("The score is not right");
        }
    }

    @Override
    public void delete(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        QualificationDAOH2Impl qualificationDAOH2 = new QualificationDAOH2Impl();
        try {
            qualificationDAOH2.delete(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The qualification does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public void update(Qualification qualification) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        QualificationDAOH2Impl qualificationDAOH2 = new QualificationDAOH2Impl();
        try {
            qualificationDAOH2.update(qualification);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The qualification does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public List<Qualification> list() throws UnableConnectionException, UnableCloseConnectionException, OperationException {
        QualificationDAOH2Impl qualificationDAOH2 = new QualificationDAOH2Impl();
        try {
            return qualificationDAOH2.list();
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    public List<Qualification> listForTeacher(Long id) throws UnableConnectionException, UnableCloseConnectionException, OperationException {
        QualificationDAOH2Impl qualificationDAOH2 = new QualificationDAOH2Impl();
        try {
            return qualificationDAOH2.listForTeacher(id);
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }

    @Override
    public Qualification search(Long id) throws EmptyFieldException, EntityNotExistException, UnableConnectionException, UnableCloseConnectionException, OperationException {
        QualificationDAOH2Impl qualificationDAOH2 = new QualificationDAOH2Impl();
        try {
            return qualificationDAOH2.search(id);
        } catch (EmptyException e) {
            throw new EmptyFieldException("There cannot be empty fields");
        } catch (NotExistException e){
            throw new EntityNotExistException("The qualification does not exist");
        } catch (UnableException e){
            throw new UnableConnectionException("The connection could not be established");
        } catch (UnableCloseException e){
            throw new UnableCloseConnectionException("The connection could not be closed");
        } catch (SQLException e){
            throw new OperationException();
        }
    }


}
