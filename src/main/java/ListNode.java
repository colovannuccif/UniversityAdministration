import java.util.ArrayList;
/**
 *
 * @author colovannucci.f
 * @param <T>
 */
public class ListNode<T> {
    private final Comparable label;
    private T value;
    private ListNode<T> nextElement;
    private static final String ELEMENT_SEPARATOR = "-";
    /**
     * Constructor de la clase ListNode.
     * @param tag
     * @param nodeValue 
     */
    public ListNode(Comparable tag, T nodeValue){
        label = tag;
        value = nodeValue;
        nextElement = null;
    }
    /**
     * Obtiene la etiqueta.
     * @return 
     */
    public Comparable getLabel(){
        return returnLabel();
    }
    /**
     * Devuelve la etiqueta.
     * @return 
     */
    private Comparable returnLabel(){
        return label;
    }
    /**
     * Obtiene el valor.
     * @return 
     */
    public T getValue(){
        return returnValue();
    }
    /**
     * Devuelve el valor.
     * @return 
     */
    private T returnValue(){
        return value;
    }
    /**
     * Actualiza el valor.
     * @param newValue 
     */
    public void setValue(T newValue){
        newValueNode(newValue);
    }
    /**
     * Modifica el valor.
     * @param newValue 
     */
    private void newValueNode(T newValue){
        value = newValue;
    }
    /**
     * Obtiene el siguiente nodo.
     * @return 
     */
    public ListNode<T> getNext(){
        return returnNextElement();
    }
    /**
     * Devuelve el siguiente nodo.
     * @return 
     */
    private ListNode returnNextElement(){
        return nextElement;
    }
    /**
     * Actualiza el siguiente nodo.
     * @param newNode 
     */
    public void setNext(ListNode<T> newNode){
        setNewNextElement(newNode);
    }
    /**
     * Modifica el siguiente nodo.
     * @param newNode 
     */
    private void setNewNextElement(ListNode<T> newNode){
        nextElement = newNode;
    }
    /**
     * Compara dos etiquetas.
     * @param givenLabel
     * @return 
     */
    private int compareLabels(Comparable givenLabel){
        return (label.compareTo(givenLabel));
    }
    /**
     * Comprueba si las etiquetas son iguales.
     * @param givenLabel
     * @return 
     */
    public boolean areEqualLabels(Comparable givenLabel){
        return (compareLabels(givenLabel) == 0);
    }
    /**
     * Comprubea si tiene siguiente elemento.
     * @return 
     */
    private boolean haveNext(){
        return (nextElement != null);
    }
    /**
     * Agrega un nodo a la lista.
     * @param newNode 
     */
    public void insertNode(ListNode<T> newNode){
        insert(newNode);
    }
    /**
     * Añade un nodo a la lista.
     * @param newNode 
     */
    private void insert(ListNode<T> newNode){
        ListNode auxNode = this;
        while (auxNode.haveNext()) {
            auxNode = auxNode.getNext();
        }
        auxNode.setNext(newNode);
    }
    /**
     * Obtiene un nodo de la lista.
     * @param givenLabel
     * @return 
     */
    public ListNode<T> searchNode(Comparable givenLabel){
        return search(givenLabel);
    }
    /**
     * Devuelve un nodo de la lista.
     * @param givenLabel
     * @return 
     */
    private ListNode<T> search(Comparable givenLabel){
        ListNode auxNode = this;
        while (!(auxNode.getNext().areEqualLabels(givenLabel)) && auxNode.haveNext()) {
            auxNode = auxNode.getNext();
        }
        return auxNode.getNext();
    }
    /**
     * Elimina un nodo de la lista.
     * @param givenLabel 
     */
    public void deleteNode(Comparable givenLabel){
        removeNode(givenLabel);
    }
    /**
     * Quita un nodo de la lista.
     * @param givenLabel 
     */
    private void removeNode(Comparable givenLabel){
        ListNode auxNode = this;
        while (!(auxNode.getNext().areEqualLabels(givenLabel)) && auxNode.haveNext()) {
            auxNode = auxNode.getNext();
        }
        auxNode.setNext(auxNode.getNext().getNext());
    }
    /**
     * Obtiene todos los nodos de la lista.
     * @return 
     */
    public ArrayList<ListNode<T>> getListNodes(){
        return returnListNodes();
    }
    /**
     * Devuelve todos los nodos de la lista.
     * @return 
     */
    private ArrayList<ListNode<T>> returnListNodes(){
        ArrayList<ListNode<T>> listNodes = new ArrayList();
        ListNode auxNode = this;
        while (auxNode != null) {
            listNodes.add(auxNode);
            auxNode = auxNode.getNext();
        }
        return listNodes;
    }
    /**
     * Obtiene todas las etiquetas de la lista.
     * @return 
     */
    public ArrayList<Comparable> getLabelsList(){
        return returnLabelsList();
    }
    /**
     * Devuelve todas las etiquetas de la lista.
     * @return 
     */
    private ArrayList<Comparable> returnLabelsList(){
        ArrayList<Comparable> labelsList = new ArrayList();
        for(ListNode<T> node : returnListNodes()){
            labelsList.add(node.getLabel());
        }
        return labelsList;
    }
    /**
     * Obtiene todos los valores de la lista.
     * @return 
     */
    public ArrayList<T> getValuesList(){
        return returnValuesList();
    }
    /**
     * Devuelve todos los valores de la lista.
     * @return 
     */
    private ArrayList<T> returnValuesList(){
        ArrayList<T> valuesList = new ArrayList();
        for(ListNode<T> node : returnListNodes()){
            valuesList.add(node.getValue());
        }
        return valuesList;
    }
    /**
     * Obtiene un texto con todas las etiquetas de la lista.
     * @return 
     */
    public String showLabelsList(){
        return returnStringLabels();
    }
    /**
     * Crea un texto con todas las etiquetas.
     * @return 
     */
    private String returnStringLabels(){
        StringBuilder labelsList = new StringBuilder();
        for(ListNode<T> node : returnListNodes()){
            labelsList.append(node.getLabel());
            if(node.getNext() != null){
                labelsList.append(ELEMENT_SEPARATOR);
            }
        }
        return labelsList.toString();
    }
    /**
     * Comprueba si la etiqueta ya está dentro de la lista.
     * @param givenLabel
     * @return 
     */
    public boolean repeatedLabel(Comparable givenLabel){
        return checkLabels(givenLabel);
    }
    /**
     * Verifica que no se repita la etiqueta en la lista.
     * @param givenLabel
     * @return 
     */
    private boolean checkLabels(Comparable givenLabel){
        ListNode auxNode = this;
        while (auxNode != null) {
            if (auxNode.areEqualLabels(givenLabel)) {
                return true;
            }
            auxNode = auxNode.getNext();
        }
        return false;
    }
}
