/**
 *
 * @author colovannucci.f
 */
public class Course {
    private final Comparable code;
    private final String name;
    private int numberStudents;
    private int studentQualification;
    /**
     * Constructor con parámetros de la clase Course.
     * @param newCode
     * @param newName 
     */
    public Course(Comparable newCode, String newName){
        code = newCode;
        name = newName;
        studentQualification = 0;
        numberStudents = 0;
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
        return ("Curso: "+ name + "\nCódigo: "+ code + "\nNúmero de Estudiantes: " + numberStudents);
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
     * Obtiene el número de estudiantes.
     * @return 
     */
    public int getNumberStudents(){
        return returnNumberStudents();
    }
    /**
     * Devuelve el número de estudiantes.
     * @return 
     */
    private int returnNumberStudents(){
        return numberStudents;
    }
    /**
     * Actualiza el nuevo número de estudiantes.
     */
    public void setNewNumberStudents(){
        setNumberStudents();
    }
    /**
     * Modifica el número de estudiantes.
     */
    private void setNumberStudents(){
        numberStudents++;
    }
    /**
     * Obtiene la calificación del estudiante.
     * @return 
     */
    public int getStudentQualification(){
        return returnStudentQualification();
    }
    /**
     * Devuelve la calificación del estudiante.
     * @return 
     */
    private int returnStudentQualification(){
        return studentQualification;
    }
    /**
     * Actualiza la nueva calificación del estudiante.
     * @param newNote 
     */
    public void setNewStudentQualification(int newNote){
        setStudentQualification(newNote);
    }
    /**
     * Modifica la calificación del estudiante.
     * @param newNote 
     */
    private void setStudentQualification(int newNote){
        studentQualification = newNote;
    }
}
