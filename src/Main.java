import dao.CourseDAOH2Impl;
import dao.TableManager;
import entities.*;
import exeptions.DAOException;
import exeptions.ServiceException;
import service.*;
import ui.WindowManager;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//TODO:
// CORREGIR LOS DAO:
//  -UPDATE NO DEBE SETEAR EL ID Y DEBE RECIBIRLO COMO PARAMETRO JUNTO CON LA ENTIDAD NUEVA
// -CREAR CONSTRUCTOR SIN EL ID, EXCEPTO DE STUDENT, ADMIN Y TEACHER
//  -SEARCH DEBE RE-USAR EL ID,
// HACER LAS VISTAS DE ALUMNO Y PROFESOR
// HACER LAS VISTAS DE LOS REPORTES
// HACER LAS VISTAS DE CALIFICACIONES E INSCRIPCIONES
// AGREGAR UN CLEAR BOTON A CRUDBUTTONS Y SU FUNCIONALIDAD
// Averiguar como hacer que entre a los catch segun lo que pase
// ACOMODAR ARCHIVOS
// A TENER EN CUENTA:
// HACER QUE EL PROFESOR LE SETEE UNA NOTA A UN ALUMNO DE X CURSO
// NO SE PUEDE AGREGAR NOTAS SI SE ALCANZO EL LIMITE
// ELIMINAR UN ALUMNO CON SUS NOTAS E INSCRIPCIONES
// 3:12:00 - 3:15:00 CLASE 13/05 -> excepciones en dao y servicios
// LAS REGLAS DE NEGOCIO SE VALIDAN EN LA CAPA DE SERVICIO

// NOTAS:
// -EN EL UNO A MUCHOS, LA CLAVE VA DEL UNO AL MUCHOS, MUCHOS TIENE LA FK

// DATOS DUMMY:
//INSERT INTO STUDENTS (NID, NAME, LAST_NAME, PASSWORD, TOTAL_COURSES) VALUES (27894125, 'Carlos', 'Del Valle', 'carlos1', 1);
//INSERT INTO STUDENTS (NID, NAME, LAST_NAME, PASSWORD, TOTAL_COURSES) VALUES (27894562, 'Lorena', 'Garcia', 'lorena', 1);
//INSERT INTO STUDENTS (NID, NAME, LAST_NAME, PASSWORD, TOTAL_COURSES) VALUES (56987123, 'Ana', 'Sanchez', 'ana123', 3);

//INSERT INTO TEACHERS (NID, NAME, LAST_NAME, PASSWORD) VALUES (30789456, 'Guido', 'Chiesa', 'guido123');

//INSERT INTO COURSES (ID, NAME, PRICE, MIDTERMS, START_DATE, END_DATE, QUOTA) VALUES (1, 'Math', 2500.80, 2, '2021-03-03', '2021-06-15', 30);
//INSERT INTO COURSES (ID, NAME, PRICE, MIDTERMS, START_DATE, END_DATE, QUOTA) VALUES (2, 'Databases', 2700.50, 2, '2021-08-09', '2021-11-22', 25);
//INSERT INTO COURSES (ID, NAME, PRICE, MIDTERMS, START_DATE, END_DATE, QUOTA) VALUES (3, 'Programming', 2950.50, 2, '2021-08-09', '2021-11-22', 25);

//INSERT INTO ENROLLMENTS (ID, STUDENT_ID, COURSE_ID) VALUES (1,27894562,1);
//INSERT INTO ENROLLMENTS (ID, STUDENT_ID, COURSE_ID) VALUES (2,56987123,3);
//INSERT INTO ENROLLMENTS (ID, STUDENT_ID, COURSE_ID) VALUES (3,27894125,2);
//INSERT INTO ENROLLMENTS (ID, STUDENT_ID, COURSE_ID) VALUES (4,56987123,1);
//INSERT INTO ENROLLMENTS (ID, STUDENT_ID, COURSE_ID) VALUES (5,56987123,2);

//INSERT INTO QUALIFICATIONS (ID, SCORE, TEACHER_ID, COURSE_ID, STUDENT_ID) VALUES (1, 6, 30789456, 1, 27894562);
//INSERT INTO QUALIFICATIONS (ID, SCORE, TEACHER_ID, COURSE_ID, STUDENT_ID) VALUES (2, 8, 30789456, 3, 56987123);

//INSERT INTO ADMINISTRATORS (NID, NAME, LAST_NAME, PASSWORD) VALUES (32789456, 'Sofia', 'Admin', 'admin')

/*
SELECT Q.ID ID, Q.SCORE SCORE, T.NID T_NID, T.NAME TEACHER_NAME, T.LAST_NAME TEACHER_LAST_NAME,
C.ID ID, C.NAME COURSE_NAME, C.PRICE PRICE,S.NID S_NID, S.NAME STUDENT_NAME,
S.LAST_NAME STUDENT_LAST_NAME FROM QUALIFICATIONS Q INNER JOIN TEACHERS T ON T.NID=Q.TEACHER_ID
INNER JOIN COURSES C ON C.ID=Q.COURSE_ID INNER JOIN STUDENTS S ON S.NID = Q.STUDENT_ID
ORDER BY ID;
 */

//SI FUNCIONA:
//EL CRUD DE STUDENTS

public class Main {

    private WindowManager manager;

    public static void main(String[] args) throws ServiceException, DAOException, SQLException {
/*
        Date start = new Date(2022,3,12);
        Date end = new Date(2022,6,2);
        Course math = new Course(1L, "math", 500.0, 2, start, end, 10);

        StudentService studentServicePrueba = new StudentService();
        System.out.println("Creo Alumnos");
        Student student1 = new Student("Pepe", "Argento", 35488259L, "pepe");
        studentServicePrueba.create(student1);

        Student student2 = new Student("Moni", "Argento", 35478559L, "moni");
        studentServicePrueba.create(student2);

        Student student3 = new Student("Paola", "Argento", 27894562L, "12345678");
        studentServicePrueba.create(student3);

        System.out.println("Ahora voy a buscar el usuario Paola");
        studentServicePrueba.search(27894562L);

        System.out.println("Modifico al alumno Moni Argento 35478651L, conservo dni y password");
        String newName = "Maria";
        String newLastName = "Garcia";
        Long newNid = 35478651L;
        String newPassword = student2.getPassword();
        Student toUpdate = new Student(newName, newLastName, newNid, newPassword);
        studentServicePrueba.update(toUpdate);

        /*if(studentServicePrueba.search(student3.getNid()) != null){
            student3.getCourses().add(math);
        }*/
/*
        System.out.println("Lista de todos los alumnos:");
        List<Student> studentList;
        studentList = studentServicePrueba.list();
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("------");

        System.out.println("Ahora voy a eliminar el usuario Maria");
        studentServicePrueba.delete(35488259L);
*/

        //TableManager qualif = new TableManager();
        //qualif.createQualificationTable();


        //  try {
        //   studentServicePrueba.create(student2);
        //}catch (EntityAlreadyExistException e) {
        //   System.out.println("EL estudiante "+student2+"YA EXISTE");
        //}

/*
*/
        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService();
        Enrollment enrollment = new Enrollment();
        enrollment.setId(7L);
        enrollment.setStudent(studentService.search(27894562L)); //56987123, 27894125
        enrollment.setCourse(courseService.search(3L));
        EnrollmentService enrollmentService = new EnrollmentService();
        enrollmentService.delete(7L);
        enrollmentService.create(enrollment);
        System.out.println("Tamaño de enrollments del curso 3: " +
                courseService.search(3L).getEnrollments().size());

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setMinimumSize(new Dimension(1100,600));
        WindowManager manager = new WindowManager(frame);
        manager.redirectToLogIn();
/*
        System.out.println("-----------STUDENTS-------------");
        StudentService studentService = new StudentService();
        System.out.println("Lista: " + studentService.list());
        System.out.println(studentService.list().size());
        Student student2 = new Student("Moni", "Argento", 35488559L, "moni");

        studentService.delete(35488559L);
        System.out.println("Lista con elemento borrado: " + studentService.list());
        System.out.println(studentService.list().size());

        studentService.create(student2);
        System.out.println("Lista con elemento añadido: " + studentService.list());
        System.out.println(studentService.list().size());

        System.out.println("Elemento buscado: " + studentService.search(27894125L));

        Student moniUpdated = new Student("Moni", "De Argento", 35488559L, "moni123");
        if(studentService.search(moniUpdated.getNid()) != null){
            studentService.update(moniUpdated);
            System.out.println("Lista con elemento actualizado: " + studentService.list());
        } else {
            System.out.println("El NID no existe");
        }

        System.out.println("-----------QUAL-------------");
        QualificationService qualificationService = new QualificationService();
        //System.out.println(qualificationService.list());
        //System.out.println(qualificationService.list().size());

        System.out.println(qualificationService.search(2L));


        System.out.println("-----------ENROLL-------------");
        EnrollmentService enrollmentService = new EnrollmentService();
        enrollmentService.delete(6L);
*//*
        Teacher gabriel = new Teacher("Gabriel", "Taboada", 23798546L, "gabi");
        TeacherService teacherService = new TeacherService();
        teacherService.create(gabriel);

        Date start = new Date(2022,3,12);
        Date end = new Date(2022,6,2);
        Course powerBi = new Course(4L, "Power Bi", 730.0, 2, start, end, 15);
        CourseService courseService = new CourseService();
        courseService.list();
        courseService.create(powerBi);

        Student student2 = new Student("Moni", "Argento", 35488559L, "moni");
        StudentService studentService = new StudentService();
        studentService.create(student2);

        Qualification qualification = new Qualification(3L, 9, gabriel, powerBi, student2);
        QualificationService qualificationService = new QualificationService();
        qualificationService.create(qualification);
*/
    }
}
