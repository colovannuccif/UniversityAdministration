
import java.util.ArrayList;

/**
 *
 * @author colovannucci.f
 */
public class SimpleLinkedList<T> {
    private ListNode firstElement;
    /**
     * Constructor de la clase SimpleLinkedList.
     */
    public SimpleLinkedList(){
        firstElement = null;
    }
    /**
     * Comprueba si la lista está vacía.
     * @return 
     */
    public boolean isEmpty(){
        return (getFirst() == null);
    }
    /**
     * Modifica el primero.
     * @param newNode 
     */
    private void setFirst(ListNode<T> newNode){
        firstElement = newNode;
    }
    /**
     * Devuelve el primero
     * @return 
     */
    private ListNode<T> getFirst(){
        return firstElement;
    }
    /**
     * Comprueba si es el primero.
     * @param givenLabel
     * @return 
     */
    private boolean isFirst(Comparable givenLabel){
        return (firstElement.areEqualLabels(givenLabel));
    }
    /**
     * Agrega un nodo a la lista.
     * @param newNode
     * @return 
     */
    public int insertNode(ListNode<T> newNode){
        if(isEmpty()){
            setFirst(newNode);
            return 1;
        } else{
            if (getFirst().repeatedLabel(newNode.getLabel())){
                return -1;//Está Repetido.
            } else {
                getFirst().insertNode(newNode);
                return 1;
            }
        }
    }
    /**
     * Obtiene un nodo de la lista.
     * @param givenLabel
     * @return 
     */
    public ListNode<T> searchNode(Comparable givenLabel){
        if(isEmpty()){
            return null;
        } else{
            if (getFirst().repeatedLabel(givenLabel)){
                if(isFirst(givenLabel)){
                    return getFirst();
                } else {
                    return getFirst().searchNode(givenLabel);
                }
            } else {
                return null;
            }
        }
    }
    /**
     * Elimina un nodo de la lista.
     * @param givenLabel
     * @return 
     */
    public int deleteNode(Comparable givenLabel){
        if(isEmpty()){
            return 0;//Está vacio.
        } else {
            if (getFirst().repeatedLabel(givenLabel)){
                if(isFirst(givenLabel)){
                    setFirst(getFirst().getNext());
                } else {
                    getFirst().deleteNode(givenLabel);
                }
                return 1;
            } else {
                return -1;//No existe la etiqueta dentro de la Lista.
            }
        }
    }
    /**
     * Muestra todas las etiquetas de la lista.
     * @return 
     */
    public String showLabelsList(){
        if(isEmpty()){
            return "";
        }else{
            return getFirst().showLabelsList();
        }
    }
    public ArrayList<ListNode<T>> getListNodes(){
        if(isEmpty()){
            return null;
        }else{
            return getFirst().getListNodes();
        }
    }
    /**
     * Obtiene todas las etiquetas de la lista.
     * @return 
     */
    public ArrayList<Comparable> getLabelsList(){
        if(isEmpty()){
            return null;
        }else{
            return getFirst().getLabelsList();
        }
    }
    /**
     * Obtiene todos los valores de la lista.
     * @return 
     */
    public ArrayList<T> getValuesList(){
        if(isEmpty()){
            return null;
        }else{
            return getFirst().getValuesList();
        }
    }
}
