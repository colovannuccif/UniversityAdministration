
import java.util.ArrayList;
/**
 *
 * @author colovannucci.f
 */
public class UniversityAdministration {
    private static UniversityAdministration instance;
    /**
     * Comprueba si la instancia es nula.
     * @return 
     */
    private static boolean isNullInstance(){
        return instance == null;
    }
    /**
     * Instancia la única abstracción posible de la clase UniversityAdministration.
     * @param classInstance 
     */
    private static void setInstance(UniversityAdministration classInstance){
        instance = classInstance;
    }
    /**
     * Obtiene la única instancia de la clase.
     * @return 
     */
    private static UniversityAdministration getInstance(){
        return instance;
    }
    /**
     * CONSTRUCTOR DE CLASE PRIVADA SINGLETON
     */
    private UniversityAdministration(){
    }
    /**
     * Inicializa la instancia UNICA del Singleton
     * @return 
     */
    public static UniversityAdministration universityInstance(){
        if(isNullInstance()){
            setInstance(new UniversityAdministration());
        }
        return getInstance();
    }
    private static final String ELEMENT_SEPARATOR = "\n-----------------------\n";
    private ArrayList<Student> UniversityStudentsList = new ArrayList();
    private ArrayList<Career> UniversityCareersList = new ArrayList();
    /**
     * Comprueba que haya estudiantes.
     * @return 
     */
    private boolean haveStudents(){
        return (!(UniversityStudentsList.isEmpty()));
    }
    /**
     * Comprueba que haya carreras.
     * @return 
     */
    private boolean haveCareers(){
        return (!(UniversityCareersList.isEmpty()));
    }
    /**
     * Comprueba que sea un estudiante válido de la universidad.
     * @param givenCode
     * @param givenCI
     * @return 
     */
    private boolean isUniversityStudent(Comparable givenCode, int givenCI){
        for (Student student : UniversityStudentsList) {
            if (student.areEqualsCodes(givenCode) || student.getCI() == givenCI) {
                return true;
            }
        }
        return false;
    }
    /**
     * Comprueba que sea una carrera válida de la universidad.
     * @param givenCode
     * @return 
     */
    private boolean isUniversityCareer(Comparable givenCode){
        for (Career career : UniversityCareersList) {
            if (career.areEqualsCodes(givenCode)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Delega al método para crear un estudiante.
     * @param studentCode
     * @param studentCI
     * @param studentName
     * @param studentLastname
     * @return 
     */
    public int createStudent(Comparable studentCode, int studentCI, String studentName, String studentLastname){
        return addStudent(studentCode, studentCI, studentName, studentLastname);
    }
    /**
     * Crea un estudiante agregandolo a su respetiva lista.
     * @param studentCode
     * @param studentCI
     * @param studentName
     * @param studentLastname
     * @return 
     */
    private int addStudent(Comparable studentCode, int studentCI, String studentName, String studentLastname){
        if(haveStudents()){
            if (isUniversityStudent(studentCode, studentCI)){
                return -1;
            }
        }
        Student newStudent = new Student(studentCode, studentCI, studentName, studentLastname);
        UniversityStudentsList.add(newStudent);
        return 1;
    }
    /**
     * Delega al método para crear una carrera.
     * @param careerCode
     * @param careerName
     * @return 
     */
    public int createCareer(Comparable careerCode, String careerName){
        return addCareer(careerCode, careerName);
    }
    /**
     * Crea una carrera agregandola a su respetiva lista.
     * @param careerCode
     * @param careerName
     * @return 
     */
    private int addCareer(Comparable careerCode, String careerName){
        if(haveCareers()){
            if (isUniversityCareer(careerCode)){
                return -1;
            }
        }
        Career newCareer = new Career(careerCode, careerName);
        UniversityCareersList.add(newCareer);
        return 1;
    }
    /**
     * Delega al método para crear un curso.
     * @param selectedCareer
     * @param courseCode
     * @param courseName
     * @return 
     */
    public int createCourse(Career selectedCareer, Comparable courseCode, String courseName){
        return addCourse(selectedCareer, courseCode, courseName);
    }
    /**
     * Crea un curso.
     * @param selectedCareer
     * @param courseCode
     * @param courseName
     * @return 
     */
    private int addCourse(Career selectedCareer, Comparable courseCode, String courseName){
        if(haveCareers()){
            if (selectedCareer != null){
                if (isUniversityCareer(selectedCareer.getCode())) {
                    return selectedCareer.createCourse(courseCode, courseName);
                } else {
                    return 3;//La carrera no existe
                }
            } else {
                return 4;//La carrera es nula
            }
        } else {
            return 0;//No hay carreras
        }
    }
    /**
     * Muestra la lista de estudiantes universitarios obtenida.
     * @return 
     */
    public String getStudentsList(){
        if(haveStudents()){
            return returnStudentsList();
        } else {
            return ("No hay ningún estudiante en la universidad.");
        }
    }
    /**
     * Obtiene los datos de todos los estudiantes de la universidad.
     * @return 
     */
    private String returnStudentsList(){
        StringBuilder studentsList = new StringBuilder();
        studentsList.append("\nLos estudiantes en la universidad son:");
        for (Student student : UniversityStudentsList){
            studentsList.append(ELEMENT_SEPARATOR);
            studentsList.append(student.getData());
        }
        return studentsList.toString();
    }
    /**
     * Muestra la lista de carreras universitarias obtenida.
     * @return 
     */
    public String getCareersList(){
        if(haveCareers()){
            return returnCareersList();
        } else {
            return ("No hay ninguna carrera en la universidad.");
        }
    }
    /**
     * Obtiene los datos de todas las carreras de la universidad.
     * @return 
     */
    private String returnCareersList(){
        StringBuilder careersList = new StringBuilder();
        careersList.append("\nLas carreras de la universidad son:");
        for (Career career : UniversityCareersList){
            careersList.append(ELEMENT_SEPARATOR);
            careersList.append(career.getData());
        }
        return careersList.toString();
    }
    /**
     * Delega al metodo para obtener la ficha de un estudiante.
     * @param givenCode
     * @return 
     */
    public Student getStudentFile(Comparable givenCode){
        return returnStudentFile(givenCode);
    }
    /**
     * Obtiene la información completa de un estudiante.
     * @param givenCode
     * @return 
     */
    private Student returnStudentFile(Comparable givenCode){
        if(haveStudents()){
            for (Student student : UniversityStudentsList) {
                if (student.areEqualsCodes(givenCode)){
                    return student;
                }
            }
            return null;
        } else {
            return null;
        }
    }
    /**
     * Delega al metodo para obtener la ficha de una carrera.
     * @param givenCode
     * @return 
     */
    public Career getCareerFile(int givenCode){
        return returnCareerFile(givenCode);
    }
    /**
     * Obtiene la información completa de una carrera.
     * @param givenCode
     * @return 
     */
    private Career returnCareerFile(int givenCode){
        if(haveCareers()){
            for (Career career : UniversityCareersList) {
                if (career.areEqualsCodes(givenCode)){
                    return career;
                }
            }
            return null;
        } else {
            return null;
        }
    }
    /**
     * Matricula un estudiante en una carrera.
     * @param selectedCareer
     * @param studentFile
     * @return 
     */
    public int enrollCareerStudent(Career selectedCareer, Student studentFile){
        if (haveCareers()) {
            if (selectedCareer != null) {
                if (studentFile != null) {
                    if (isUniversityStudent(studentFile.getCode(), studentFile.getCI())) {
                        return selectedCareer.registerStudent(studentFile.getCode(), studentFile);
                    } else {
                        return 2;//El estudiante es inexistente
                    }
                } else {
                    return 3;//El estudiante es nulo.
                }
            } else {
                return 4;//La carrera es nula.
            }
        } else {
            return 0;//No hay carreras.
        }
    }
    /**
     * Califica un estudiante de un curso.
     * @param selectedCareer
     * @param studentFile
     * @param selectedCourse
     * @param newStudentNote
     * @return 
     */
    public int qualifyStudent(Career selectedCareer, Student studentFile, Comparable selectedCourse, int newStudentNote){
        if (newStudentNote >= 0 && newStudentNote <= 6){
            if (haveCareers()) {
                if (selectedCareer != null) {
                    if (studentFile != null) {
                        if (isUniversityStudent(studentFile.getCode(), studentFile.getCI())) {
                            return selectedCareer.setNewStudentQualification(selectedCourse, studentFile, newStudentNote);
                        } else {
                            return 2;//El estudiante es inexistente
                        }
                    } else {
                        return 3;//El estudiante es nulo.
                    }
                } else {
                    return 4;//La carrera es nula.
                }
            } else {
                return 0;//No hay carreras.
            }
        } else {
            return -2;//La nota está fuera del rango permitido
        }
    }
    /**
     * Obtiene las notas del estudiante en un curso.
     * @param selectedCareer
     * @param studentFile
     * @param selectedCourse
     * @return 
     */
    public String getCourseStudentQualification(Career selectedCareer, Student studentFile, Comparable selectedCourse){
        if (haveCareers()) {
            if (selectedCareer != null) {
                if (studentFile != null) {
                    if (isUniversityStudent(studentFile.getCode(), studentFile.getCI())) {
                        return selectedCareer.getCourseStudentQualification(studentFile, selectedCourse);
                    } else {
                        return ("El estudiante es inexistente.");
                    }
                } else {
                    return ("El estudiante es nulo.");
                }
            } else {
                return ("La carrera es nula.");
            }
        } else {
            return ("No hay carreras.");
        }
    }
    /**
     * Obtiene las notas del estudiante en todos los cursos.
     * @param selectedCareer
     * @param studentFile
     * @return 
     */
    public String getAllCoursesStudentQualifications(Career selectedCareer, Student studentFile){
        if (haveCareers()) {
            if (selectedCareer != null) {
                if (studentFile != null) {
                    if (isUniversityStudent(studentFile.getCode(), studentFile.getCI())) {
                        return selectedCareer.getAllCoursesStudentQualifications(studentFile);
                    } else {
                        return ("El estudiante es inexistente.");
                    }
                } else {
                    return ("El estudiante es nulo.");
                }
            } else {
                return ("La carrera es nula.");
            }
        } else {
            return ("No hay carreras.");
        }
    }
    /**
     * Muestra todos los estudiantes de una carrera.
     * @param selectedCareer
     * @return 
     */
    public String showCareerStudents(Career selectedCareer){
        if (haveCareers()){
            if (selectedCareer != null){
                String studentsList = selectedCareer.showCareerStudents();
                if (studentsList.equals("")){
                    return ("No hay ningún alumno en la carrera \"" + selectedCareer.getName() + "\".");
                } else {
                    return studentsList;
                }
            } else {
                return ("\nNo existe la carrera seleccionada.");
            }
        } else {
            return ("\nNo hay ninguna carrera en la universidad.");
        }
    }
    /**
     * Muestra todos los cursos de una carrera.
     * @param selectedCareer
     * @return 
     */
    public String showCareerCourses(Career selectedCareer){
        if (haveCareers()){
            if (selectedCareer != null){
                String coursesList = selectedCareer.showCareerCourses();
                if (coursesList.equals("")){
                    return ("\nNo hay ningún curso en la carrera \"" + selectedCareer.getName() + "\".");
                } else {
                    return coursesList;
                }
            } else {
                return ("\nNo existe la carrera seleccionada.");
            }
        } else {
            return ("\nNo hay ninguna carrera en la universidad.");
        }
    }
}
