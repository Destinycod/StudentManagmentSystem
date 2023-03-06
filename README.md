# StudentManagmentSystem

El proyecto es un Sistema de administración de alumnos desarrollado para el final de la materia Laboratorio 1 de la Universidad de Palermo.

CONSIGNAS:

Se debe desarrollar un sistema de administración de cursos y alumnos.
Funcionalidad Básica:
Administrar usuarios: los administradores pueden crear cursos y dar de alta alumnos. Los usuarios
profesores pueden ingresar datos sobre el curso o alumno (calificaciones, por ejemplo)
Cada curso tiene un precio y un cupo.
Cada alumno debe tener un límite de cursos a los que se puede anotar a la vez. Como cada curso
debe aprobarse, se deben manejar calificaciones (solo finales).
Cada curso debe tener el parámetro de aprobación (nota). Si un alumno se anotó en 3 cursos
(suponiendo que 3 es el cupo), debe finalizar y aprobar un curso para poder anotarse en el otro.
Se debe poder emitir un reporte de los cursos, sus anotados y su recaudación en dinero.
Mostrar un reporte de la recaudación de los cursos.

Adicionales:
Manejar calificaciones parciales. No se puede incluir una nota final si no se tienen las n parciales
aprobadas.
En este caso cada curso tendrá una configuración de cuantas notas parciales son necesarias.
Manejar promociones por fechas, donde el valor del curso pueda tener un valor reducido entre un
rango de fechas
Mostrar un reporte de recaudación por curso. Mostrar un reporte de anotados vs aprobados por
curso.

Bonus points:
Manejar abonos (si un alumno tiene un abono, anotarse le cuesta cero pesos - prorratear el valor
del abono en la suscripción, para poder emitir el reporte correctamente de recaudación)
