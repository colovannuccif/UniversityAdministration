
import java.util.ArrayList;

/**
 *
 * @author colovannucci.f
 */
public class Career {
    private final String name;
    private final Comparable code;
    private SimpleLinkedList CareerCoursesList = new SimpleLinkedList();
    private BinaryTree CareerStudentsList = new BinaryTree();
    private static final String ELEMENT_SEPARATOR = "\n-----------------------\n";
    /**
     * Constructor con parámetros de la clase Career.
     * @param careerCode
     * @param careerName 
     */
    public Career(Comparable careerCode, String careerName){
        code = careerCode;
        name = careerName;
    }
    /**
     * Obtiene el codigo.
     * @return 
     */
    public Comparable getCode(){
        return returnCode();
    }
    /**
     * Devuelve el codigo.
     * @return 
     */
    private Comparable returnCode(){
        return code;
    }
    /**
     * Obtiene el nombre.
     * @return 
     */
    public String getName(){
        return returnName();
    }
    /**
     * Devuelve el nombre.
     * @return 
     */
    private String returnName(){
        return name;
    }
    /**
     * Obtiene la informacion completa.
     * @return 
     */
    public String getData(){
        return returnData();
    }
    /**
     * Devuelve la informacion en modo ficha
     * @return 
     */
    private String returnData(){
        return ("Carrera: "+ name + "\nCódigo: "+ code);
    }
    /**
     * Comprueba si tiene estudiantes.
     * @return 
     */
    private boolean haveStudents(){
        return (!(CareerStudentsList.isEmpty()));
    }
    /**
     * Comprueba si tiene cursos.
     * @return 
     */
    private boolean haveCourses(){
        return (!(CareerCoursesList.isEmpty()));
    }
    /**
     * Comprueba si dos etiquetas son iguales.
     * @param givenCode
     * @return 
     */
    public boolean areEqualsCodes(Comparable givenCode){
        return compareCodes(givenCode);
    }
    /**
     * Compara dos etiquetas y devuelve si son iguales o no.
     * @param givenCode
     * @return 
     */
    private boolean compareCodes(Comparable givenCode){
        return ((code.compareTo(givenCode)) == 0);
    }
    /**
     * Comprueba que sea un estudiante válido de la carrera.
     * @param givenCode
     * @param givenCI
     * @return 
     */
    private boolean isCareerStudent(Comparable givenCode, int givenCI){
        if (haveStudents()) {
            ArrayList<Student> studentsNodes = CareerStudentsList.getValuesList();
            for (Student student : studentsNodes) {
                if (student.areEqualsCodes(givenCode) || student.getCI() == givenCI) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
    /**
     * Comprueba que sea un curso válido de la carrera.
     * @param givenCode
     * @return 
     */
    private boolean isCareerCourse(Comparable givenCode){
        if (haveCourses()) {
            ArrayList<ListNode> coursesNodes = CareerCoursesList.getListNodes();
            for (ListNode courseNode : coursesNodes) {
                if (courseNode.areEqualLabels(givenCode)){
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
    /**
     * Registra un estudiante en la carrera.
     * @param studentCode
     * @param studentFile
     * @return 
     */
    public int registerStudent(Comparable studentCode, Student studentFile){
        return addStudent(studentCode, studentFile);
    }
    /**
     * Añade un estudiante a la lista.
     * @param studentCode
     * @param studentFile
     * @return 
     */
    private int addStudent(Comparable studentCode, Student studentFile){
        if(studentFile.getEnrollment() || isCareerStudent(studentCode, studentFile.getCI())){
            return -1;//Ya está Matriculado o ya hay un estudiante con esa cédula dentro de la carrera.
        } else {
            studentFile.setNewEnrollment(name);
            if (haveCourses()){
                ArrayList<Course> coursesNodes = CareerCoursesList.getValuesList();
                for (Course course : coursesNodes) {
                    //Creamos uno nuevo para que la nota del curso general no se superponga con la del estudiante
                    Course studentCourse = new Course(course.getCode(), course.getName());
                    studentFile.setNewCourse(studentCourse);
                    course.setNewNumberStudents();
                }
            }
            TreeNode studentNode = new TreeNode(studentCode, studentFile);
            CareerStudentsList.insertNode(studentNode);
            return 1;
        }
    }
    /**
     * Registra un curso en la carrera.
     * @param courseCode
     * @param courseName
     * @return 
     */
    public int createCourse(Comparable courseCode, String courseName){
        return addCourse(courseCode, courseName);
    }
    /**
     * Añade un curso a la lista.
     * @param courseCode
     * @param courseName
     * @return 
     */
    private int addCourse(Comparable courseCode, String courseName){
        if(isCareerCourse(courseCode)){
            return -1;//Ya está Creado o ya hay un curso con ese código dentro de la carrera.
        } else {
            Course courseFile = new Course(courseCode, courseName);
            if (haveStudents()){
                ArrayList<Student> studentsNodes = CareerStudentsList.getValuesList();
                for (Student student : studentsNodes) {
                    courseFile.setNewNumberStudents();
                    //Creamos uno nuevo para que la nota del curso general no se superponga con la del estudiante
                    Course studentCourse = new Course(courseCode, courseName);
                    student.setNewCourse(studentCourse);
                }
            }
            ListNode courseNode = new ListNode(courseCode, courseFile);
            CareerCoursesList.insertNode(courseNode);
            return 1;
        }
    }
    /**
     * Obtiene el número de estudiantes en la carrera.
     * @return 
     */
    public String getNumberCareerStudents(){
        int numberCareerStudents = returnNumberCareerStudents();
        if (numberCareerStudents == 0){
            return ("\nNo hay ningún estudiante en la carrera " + getName());
        } else {
            return ("\nHay " + numberCareerStudents + " estudiantes dentro de la carrera " + getName());
        }
    }
    /**
     * Devuelve el número de estudiantes en la carrera.
     * @return 
     */
    private int returnNumberCareerStudents(){
        if (haveStudents()) {
            int studentCounter = 0;
            ArrayList<TreeNode> studentsNodes = CareerStudentsList.getTreeNodes();
            for (TreeNode studentNode : studentsNodes) {
                studentCounter++;
            }
            return studentCounter;
        } else {
            return 0;
        }
    }
    /*
    public String getNumberCourseStudents(Comparable givenCode){
        if(haveCourses()){
            if (isCareerCourse(givenCode)) {
                int numberCourseStudents = returnNumberCourseStudents(givenCode);
                if (numberCourseStudents == 0) {
                    return ("\nNo hay ningún estudiante en el curso " + getName());
                } else {
                    return ("\nHay " + numberCourseStudents + " estudiantes dentro del curso " + getName());
                }
            } else {
                return ("\nEl curso es inexistente.");
            }
        }else {
            return ("\nNo hay Cursos.");
        }
    }
    private int returnNumberCourseStudents(Comparable givenCode){
        if(haveCourses()){
            ArrayList<Course> coursesNodes = CareerCoursesList.getValuesList();
            for (Course course : coursesNodes) {
                if (course.areEqualsCodes(givenCode)){
                   return course.getNumberStudents();
                }
            }
            return 0;
        } else {
            return 0;
        }
    }
*/
    /**
     * Obtiene la calificación de un alumno en determinado curso.
     * @param studentFile
     * @param courseCode
     * @return 
     */
    public String getCourseStudentQualification(Student studentFile, Comparable courseCode){
        return returnCourseStudentQualification(studentFile, courseCode);
    }
    /**
     * Devuelve la calificación del alumno en un curso
     * @param studentFile
     * @param selectedCourse
     * @return 
     */
    private String returnCourseStudentQualification(Student studentFile, Comparable selectedCourse){
        if(haveCourses()){
            if (isCareerCourse(selectedCourse)) {
                if (isCareerStudent(studentFile.getCode(), studentFile.getCI())) {
                    return studentFile.getCourseQualification(selectedCourse);
                } else {
                    return ("\nNo es estudiante de esta carrera.");
                }
            } else {
                return ("\nEl curso es inexistente.");
            }
        }else {
            return ("\nNo hay Cursos.");
        }
    }
    /**
     * Obtiene la calificación de un alumno en todos los cursos.
     * @param studentFile
     * @return 
     */
    public String getAllCoursesStudentQualifications(Student studentFile){
        return returnCourseStudentQualification(studentFile);
    }
    /**
     * Devuelve las calificaciones del alumno en todos los cursos.
     * @param studentFile
     * @return 
     */
    private String returnCourseStudentQualification(Student studentFile){
        if(haveCourses()){
            if (isCareerStudent(studentFile.getCode(), studentFile.getCI())) {
                return studentFile.getAllQualifications();
            } else {
                return ("\nNo es estudiante de esta carrera.");
            }
        }else {
            return ("\nNo hay Cursos.");
        }
    }
    /**
     * Establece la calificacion de un estudiante en el curso.
     * @param selectedCourse
     * @param studentFile
     * @param newStudentNote
     * @return 
     */
    public int setNewStudentQualification(Comparable selectedCourse, Student studentFile, int newStudentNote){
        return setStudentQualification(selectedCourse, studentFile, newStudentNote);
    }
    /**
     * Modifica la calificacion del estudiante en un curso.
     * @param selectedCourse
     * @param studentFile
     * @param newStudentNote
     * @return 
     */
    private int setStudentQualification(Comparable selectedCourse, Student studentFile, int newStudentNote){
        if(haveCourses()){
            if (isCareerCourse(selectedCourse)) {
                if (isCareerStudent(studentFile.getCode(), studentFile.getCI())) {
                    studentFile.setNewQualification(selectedCourse, newStudentNote);
                    return 1;//Se ingresó correctamente
                } else {
                    return 6;//No es estudiante de esta carrera
                }
            } else {
                return 7;//El curso es inexistente;
            }
        }else {
            return 5;//No hay Cursos.
        }
    }
    /**
     * Obtiene la lista de estudiantes en una carrera.
     * @return 
     */
    public String showCareerStudents(){
        return listCareerStudents();
    }
    /**
     * Devuelve una lista con todos los estudiantes de una carrera.
     * @return 
     */
    private String listCareerStudents(){
        if (haveStudents()) {
            ArrayList<Student> studentsNodes = CareerStudentsList.getValuesList();
            StringBuilder studentsListCareer = new StringBuilder();
            studentsListCareer.append(getNumberCareerStudents());
            studentsListCareer.append("\nLos estudiantes en la carrera son:");//\"");
            //studentsListCareer.append(name);
            //studentsListCareer.append("\" son:");
            for (Student student : studentsNodes) {
                studentsListCareer.append(ELEMENT_SEPARATOR);
                studentsListCareer.append(student.getData());
            }
            return studentsListCareer.toString();
        } else {
            return "";
        }
    }
    /**
     * Obtiene la lista de cursos en una carrera.
     * @return 
     */
    public String showCareerCourses(){
        return listCareerCourses();
    }
    /**
     * Devuelve una lista con todos los cursos de una carrera.
     * @return 
     */
    private String listCareerCourses(){
        if (haveCourses()) {
            ArrayList<Course> coursesNodes = CareerCoursesList.getValuesList();
            StringBuilder coursesListCareer = new StringBuilder();
            coursesListCareer.append("\nLos cursos en la carrera \"");
            coursesListCareer.append(name);
            coursesListCareer.append("\" son:");
            for (Course course : coursesNodes) {
                coursesListCareer.append(ELEMENT_SEPARATOR);
                coursesListCareer.append(course.getData());
            }
            return coursesListCareer.toString();
        } else {
            return "";
        }
    }
}
