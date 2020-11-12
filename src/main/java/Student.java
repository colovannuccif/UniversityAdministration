
import java.util.ArrayList;

/**
 *
 * @author colovannucci.f
 */
public class Student {
    private final Comparable code;
    private final int CI;
    private final String surname;
    private final String name;
    private String selectedCareer;
    private boolean enrollment;
    private ArrayList<Course> coursesList = new ArrayList();
    private static final String ELEMENT_SEPARATOR = "\n-----------------------\n";
    /**
     * Constructor con parámetros de la clase Student.
     * @param newCode
     * @param newCI
     * @param newName
     * @param lastname 
     */
    public Student(Comparable newCode, int newCI, String newName, String lastname){
        code = newCode;
        CI = newCI;
        name = newName;
        surname =lastname;
        enrollment = false;
    }
    /**
     * Obtiene el codigo.
     * @return 
     */
    public Comparable getCode(){
        return returnStudentCode();
    }
    /**
     * Devuelve el codigo.
     * @return 
     */
    private Comparable returnStudentCode(){
        return code;
    }
    /**
     * Obtiene la Cedula de Identidad.
     * @return 
     */
    public int getCI(){
        return returnCI();
    }
    /**
     * Devuelve la Cedula de Identidad.
     * @return 
     */
    private int returnCI(){
        return CI;
    }
    /**
     * Obtiene el apellido.
     * @return 
     */
    public String getSurname(){
        return returnSurname();
    }
    /**
     * Devuelve el nombre.
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
     * Devuelve el apellido.
     * @return 
     */
    private String returnSurname(){
        return surname;
    }
    /**
     * Comprueba si está matriculado en una carrera.
     * @return 
     */
    public boolean isEnrolled(){
        return getEnrollment() == true;
    }
    /**
     * Obtiene si está matriculado o no.
     * @return 
     */
    public boolean getEnrollment(){
        return returnEnrollment();
    }
    /**
     * Devuelve si está matriculado o no.
     * @return 
     */
    private boolean returnEnrollment(){
        return enrollment;
    }
    /**
     * Actualiza la matricula de un estudiante en una carrera.
     * @param nameCareer 
     */
    public void setNewEnrollment(String nameCareer){
        setEnrollment(nameCareer);
    }
    /**
     * Modifica la matricula de un estudiante en una carrera.
     * @param nameCareer 
     */
    private void setEnrollment(String nameCareer){
        selectedCareer = nameCareer;
        enrollment = true;
    }
    /**
     * Obtiene el nombre de la carrera en que está matriculado.
     * @return 
     */
    public String getCareer(){
        return returnCareer();
    }
    /**
     * Devuelve el nombre de la carrera en que está matriculado.
     * @return 
     */
    private String returnCareer(){
        return selectedCareer;
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
        return ("Estudiante: "+ surname + ","+ name +"\nCI: "+ CI +"\nCódigo Estudiante: "+ code);
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
     * Actualiza la lista de cursos.
     * @param course 
     */
    public void setNewCourse(Course course){
        setCourse(course);
    }
    /**
     * Añade un curso a la lista.
     * @param course 
     */
    private void setCourse(Course course){
        coursesList.add(course);
    }
    /**
     * Actualiza una calificación de un curso.
     * @param courseCode
     * @param newNote 
     */
    public void setNewQualification(Comparable courseCode, int newNote){
        setQualification(courseCode, newNote);
    }
    /**
     * Modifica la calificación de un curso.
     * @param courseCode
     * @param newNote 
     */
    private void setQualification(Comparable courseCode, int newNote){
        for(Course course : coursesList){
            if(course.areEqualsCodes(courseCode)){
                course.setNewStudentQualification(newNote);
            }
        }
    }
    /**
     * Obtiene la calificación de un curso.
     * @param courseCode
     * @return 
     */
    public String getCourseQualification(Comparable courseCode){
        return returnCourseQualification(courseCode);
    }
    /**
     * Devuelve la calificación de un curso.
     * @param courseCode
     * @return 
     */
    private String returnCourseQualification(Comparable courseCode){
        StringBuilder qualificationCourse = new StringBuilder();
        qualificationCourse.append("\nCalificacion del Alumno \"");
        qualificationCourse.append(surname);
        qualificationCourse.append(", ");
        qualificationCourse.append(name);
        qualificationCourse.append("\":");
        for (Course course : coursesList) {
            if (course.areEqualsCodes(courseCode)){
                qualificationCourse.append(ELEMENT_SEPARATOR);
                qualificationCourse.append("Nombre Curso: ");
                qualificationCourse.append(course.getName());
                qualificationCourse.append("\nNota Curso: ");
                qualificationCourse.append(course.getStudentQualification());
            }
        }
        return qualificationCourse.toString();
    }
    /**
     * Obtiene todas las calificaciones de los cursos.
     * @return 
     */
    public String getAllQualifications(){
        return returnAllQualifications();
    }
    /**
     * Devuelve todas las calificaciones de los cursos.
     * @return 
     */
    private String returnAllQualifications(){
        StringBuilder qualificationsCourses = new StringBuilder();
        qualificationsCourses.append("\nCalificaciones del Alumno \"");
        qualificationsCourses.append(surname);
        qualificationsCourses.append(", ");
        qualificationsCourses.append(name);
        qualificationsCourses.append("\":");
        for (Course course : coursesList) {
            qualificationsCourses.append(ELEMENT_SEPARATOR);
            qualificationsCourses.append("Nombre Curso: ");
            qualificationsCourses.append(course.getName());
            qualificationsCourses.append("\nNota Curso: ");
            qualificationsCourses.append(course.getStudentQualification());
        }
        return qualificationsCourses.toString();
    }
}
