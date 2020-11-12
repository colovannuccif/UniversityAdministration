
import java.util.ArrayList;

/**
 *
 * @author colovannucci.f
 */
public class MainUniversity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UniversityAdministration UCU = UniversityAdministration.universityInstance();
        
        final String APROBACION_MESSAGE = "\nSe agregó correctamente.";
        final String DENEGATE_MESSAGE = "\nEste código ya existe.";
        final String FOUND_MESSAGE = "\nSe encontró correctamente.";
        final String ERROR_CODE_MESSAGE = "\nEste código NO existe.";
        
        //Demostramos que alumnos y carreras comienzan vacios
        System.out.println(UCU.getStudentsList());
        System.out.println(UCU.getCareersList());
        
        //Añadimos estudiantes y carreras a la universidad
        int agregacionEstudiante1 = UCU.createStudent(1, 12345678, "Franco", "Vannucci");
        if (agregacionEstudiante1 == 1){
            System.out.println(APROBACION_MESSAGE);
        }
        UCU.createStudent(2, 2345678, "Antonella", "Piastri");
        UCU.createStudent(3, 345678, "Joaquin", "Da Rosa");
        int agregacionCarrera1 = UCU.createCareer(1, "Lic.Informática");
        if (agregacionCarrera1 == 1){
            System.out.println(APROBACION_MESSAGE);
        }
        UCU.createCareer(2, "Contador");
        UCU.createCareer(3, "Adm. Empresas");
        
        //Comprobamos la agregación
        System.out.println(UCU.getStudentsList());
        System.out.println(UCU.getCareersList());
        
        //Tratamos de agregar estudiantes repetidos usando la misma cedula de antonella para juan
        int agregacionEstudiante2 = UCU.createStudent(2, 2345678, "Juan", "Perez");
        if (agregacionEstudiante2 == -1){
            System.out.println(DENEGATE_MESSAGE);
        }
        int agregacionCarrera2 = UCU.createCareer(2, "Ing. Civil");
        if (agregacionCarrera2 == -1){
            System.out.println(DENEGATE_MESSAGE);
        }
        
        //Comprobamos que no haya agregado a repetidos
        System.out.println(UCU.getStudentsList());
        System.out.println(UCU.getCareersList());
        
        //Obtenemos un estudiante y una carrera
        Student student1 = UCU.getStudentFile(1);
        Career career1 = UCU.getCareerFile(1);
        if (student1 != null){
            System.out.println(FOUND_MESSAGE);
            System.out.println("Está matriculado en alguna carrera?: "+ student1.getEnrollment());
        }
        if (career1 != null){
            System.out.println(FOUND_MESSAGE);
        }
        
        //Obtenemos objetos NULOS
        Student student2 = UCU.getStudentFile(5);
        Career career2 = UCU.getCareerFile(6);
        if (student2 == null){
            System.out.println(ERROR_CODE_MESSAGE);
        }
        if (career2 == null){
            System.out.println(ERROR_CODE_MESSAGE);
        }
        
        //Mostramos la lista de alumnos de una carrera
        System.out.println(UCU.showCareerStudents(career1));
        
        //Agregamos un estudiante a la carrera
        int registroEstudiante1 = UCU.enrollCareerStudent(career1, student1);
        if (registroEstudiante1 == 1){
            System.out.println(APROBACION_MESSAGE);
            System.out.println("Se matriculó desde la la clase delegadora?: "+student1.getEnrollment());
        }
        
        //Confirmamos la lista de alumnos en la carrera luego de agregar un estudiante
        System.out.println(UCU.showCareerStudents(career1));
        
        //Tratamos de agregar estudiantes repetidos a la carrera
        int registroEstudiante2 = UCU.enrollCareerStudent(career1, student1);
        if (registroEstudiante2 == -1){
            System.out.println(DENEGATE_MESSAGE);
        }
        
        //Obtenemos un estudiante (Antonella)
        Student student4 = UCU.getStudentFile(2);
        //Agregamos un estudiante a la carrera
        int registroEstudiante6 = UCU.enrollCareerStudent(career1, student4);
        if (registroEstudiante6 == 1){
            System.out.println(APROBACION_MESSAGE);
            System.out.println("Se matriculó desde la la clase delegadora: "+student1.getEnrollment());
        }
        
        //Tratamos de agregar estudiantes inexistentes a la carrera
        //Ejemplo 1.. misma cedula distinto codigo
        Student student3 = new Student(4, 12345678, "Pepito", "Cavani");
        //Ejemplo 2.. mismo codigo distinta cedula
        //Student student3 = new Student(1, 45678911, "Pepito", "Cavani");
        int registroEstudiante4 = UCU.enrollCareerStudent(career1, student3);
        if (registroEstudiante4 == 2){
            System.out.println("\nEs inexistente.");
        }
        
        //Tratamos de agregar estudiantes nulos a la carrera
        int registroEstudiante3 = UCU.enrollCareerStudent(career1, student2);
        if (registroEstudiante3 == 3){
            System.out.println("\nEs nulo.");
        }
        
        //Mostramos la lista de alumnos de una carrera que no existe
        System.out.println(UCU.showCareerStudents(career2));
        
        //Tratamos de agregar estudiantes a una carrera inexistente
        int registroEstudiante5 = UCU.enrollCareerStudent(career2, student1);
        if (registroEstudiante5 == 4){
            System.out.println("\nEsta Carrera no existe.");
        }
        
        //Confirmamos la lista de alumnos en la carrera luego de agregar un estudiante
        System.out.println(UCU.showCareerStudents(career1));
        
        //Demostramos que cursos comienzan vacios
        System.out.println(UCU.showCareerCourses(career1));
        
        //Tratamos de mostrar la lista de una carrera nula
        System.out.println(UCU.showCareerCourses(career2));
        
        //Creamos un curso dentro de la carrera
        int registroCurso1 = UCU.createCourse(career1, 1, "Algoritmos y Estructuras de Datos I");
        if (registroCurso1 == 1){
            System.out.println(APROBACION_MESSAGE);
        }
        
        //Comprobamos la Aprobación
        System.out.println(UCU.showCareerCourses(career1));
        
        //Tratamos de ingresar un curso repetido
        int registroCurso2 = UCU.createCourse(career1, 1, "Liderazgo");
        if (registroCurso2 == -1){
            System.out.println(DENEGATE_MESSAGE);
        }
        
        //Agregamos otro curso esta vez con etiqueta correcta sin repetir
        int registroCurso3 = UCU.createCourse(career1, 2, "Liderazgo");
        if (registroCurso3 == 1){
            System.out.println(APROBACION_MESSAGE);
        }
        
        //Mostramos las calificaciones del estudiante en el curso con etiqueta 1
        System.out.println(UCU.getCourseStudentQualification(career1, student1,1));
        
        //Mostramos las calificaciones del estudiante en todos los cursos
        System.out.println(UCU.getAllCoursesStudentQualifications(career1, student1));
        
        //Calificamos al alumno 1
        int calificacionEstudiante1 = UCU.qualifyStudent(career1, student1, 1, 6);
        if (calificacionEstudiante1 == 1){
            System.out.println(APROBACION_MESSAGE);
        }
        
        //Calificamos al alumno 1 con una nota incorrecta
        int calificacionEstudiante2 = UCU.qualifyStudent(career1, student1, 1, 12);
        if (calificacionEstudiante2 == -2){
            System.out.println("La nota debe estar comprendida entre 0 y 6");
        }
        
        //Comprobamos el ingreso
        //Mostramos las calificaciones del estudiante en el curso con etiqueta 1
        System.out.println(UCU.getCourseStudentQualification(career1, student1,1));
        //Mostramos las calificaciones del estudiante en todos los cursos
        System.out.println(UCU.getAllCoursesStudentQualifications(career1, student1));
        
        //Y por ultimo demostramos que solo modificó en el estudiante 1 y no en el 2(Antonella)
        //Mostramos las calificaciones del estudiante en el curso con etiqueta 1
        System.out.println(UCU.getCourseStudentQualification(career1, student4,1));
        //Mostramos las calificaciones del estudiante en todos los cursos
        System.out.println(UCU.getAllCoursesStudentQualifications(career1, student4));
        
        //Calificamos al alumno 2(Antonella)
        int calificacionEstudiante3 = UCU.qualifyStudent(career1, student4, 2, 4);
        if (calificacionEstudiante3 == 1){
            System.out.println(APROBACION_MESSAGE);
        }
        
        //Comprobamos el ingreso
        //Mostramos las calificaciones del estudiante en el curso con etiqueta 1
        System.out.println(UCU.getCourseStudentQualification(career1, student4,2));
        //Mostramos las calificaciones del estudiante en todos los cursos
        System.out.println(UCU.getAllCoursesStudentQualifications(career1, student4));
        
        /*
        //PRUEBAS
        SimpleLinkedList lista = new SimpleLinkedList();
        BinaryTree arbol = new BinaryTree();
        
        if(arbol.pathInOrder() == ""){System.out.println("\narbol vacio");}
        
        TreeNode NArbol1 = new TreeNode(23, 1);
        arbol.insertNode(NArbol1);
        System.out.println("\nInsercion 1:");
        System.out.println("Arbol:"+arbol.pathInOrder());
        
        TreeNode NArbol2 = new TreeNode(34, 2);
        arbol.insertNode(NArbol2);
        System.out.println("\nInsercion 2:");
        System.out.println("Arbol:"+arbol.pathInOrder());
        
        TreeNode NArbol3 = new TreeNode(66, 3);
        arbol.insertNode(NArbol3);
        System.out.println("\nInsercion 3:");
        System.out.println("Arbol:"+arbol.pathInOrder());
        
        TreeNode NArbol4 = new TreeNode(1, 4);
        arbol.insertNode(NArbol4);
        System.out.println("\nInsercion 4:");
        System.out.println("Arbol:"+arbol.pathInOrder());
        
        TreeNode NArbol5 = new TreeNode(34, 5);
        arbol.insertNode(NArbol5);
        System.out.println("\nInsercion 5 (Repetido):");
        System.out.println("Arbol:"+arbol.pathInOrder());
        
        TreeNode NArbol6 = new TreeNode(23, 6);
        int b = arbol.insertNode(NArbol6);
        if(b == -1){
            System.out.println("\nInsercion 6 (Repetido):");
        }
        System.out.println("Arbol:"+arbol.pathInOrder());
        
        TreeNode NArbol7 = new TreeNode(15, 7);
        int a = arbol.insertNode(NArbol7);
        if(a == 1){
            System.out.println("\nInsercion 7:");
        }
        System.out.println("Arbol:"+arbol.pathInOrder());
        
        //Eliminación
        int c = arbol.deleteNode(34);
        if(c == -1){
            System.out.println("raiz");
        } else if (c == 1){
            System.out.println("eliminado el 34");
        }
        System.out.println("Arbol:"+arbol.pathInOrder());
        
        TreeNode nodoBuscado = arbol.searchNode(23);
        if(nodoBuscado != null){
            System.out.println("Se encontró la etiqueta 23");
            System.out.println(nodoBuscado.getLabel());
        } else {
            System.out.println("No existe nodo con esa etiqueta");
        }
        
        if(lista.showLabelsList() == ""){System.out.println("\nlista vacia");}
        
        ListNode NLista1 = new ListNode(45, 1);
        lista.insertNode(NLista1);
        System.out.println("\nInsercion 1:");
        System.out.println("Lista:"+lista.showLabelsList());
        
        ListNode NLista2 = new ListNode(50, 2);
        lista.insertNode(NLista2);
        System.out.println("\nInsercion 2:");
        System.out.println("Lista:"+lista.showLabelsList());
        
        ListNode NLista3 = new ListNode(77, 3);
        lista.insertNode(NLista3);
        System.out.println("\nInsercion 3:");
        System.out.println("Lista:"+lista.showLabelsList());
        
        ListNode NLista4 = new ListNode(2, 4);
        lista.insertNode(NLista4);
        System.out.println("\nInsercion 4:");
        System.out.println("Lista:"+lista.showLabelsList());
        
        ListNode NLista5 = new ListNode(50, 5);
        lista.insertNode(NLista5);
        System.out.println("\nInsercion 5 (Repetido):");
        System.out.println("Lista:"+lista.showLabelsList());
        
        ListNode NLista6 = new ListNode(2, 6);
        lista.insertNode(NLista6);
        System.out.println("\nInsercion 6 (Repetido):");
        System.out.println("Lista:"+lista.showLabelsList());
        
        
        //lista.deleteNode(2);
        //System.out.println("\nEliminación etiqueta 2:");
        //System.out.println("Lista:"+lista.showLabelsList());
        
        ListNode nodoBuscado1 = lista.searchNode(2);
        if(nodoBuscado1 != null){
            System.out.println("Se encontró la etiqueta 2");
        } else {
            System.out.println("No existe nodo con esa etiqueta");
        }
        
        try{
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        ArrayList<Object> arrayLista = lista.getValuesList();
        
        if (arrayLista != null) {
            System.out.println("lista");
            for (Object num : arrayLista) {
                System.out.println(num);
            }
        } else {
            System.out.println("nada");
        }
        
        ArrayList<Object> arrayArbol = arbol.getValuesList();
          
        if (arrayArbol != null) {
            System.out.println("arbol");
            for (Object num : arrayArbol) {
                System.out.println(num.toString());
            }
        } else {
            System.out.println("nada");
        }
        */
    }
    
}
