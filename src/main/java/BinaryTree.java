
import java.util.ArrayList;

/**
 *
 * @author colovannucci.f
 */
public class BinaryTree<T> {
    private TreeNode root;
    /**
     * Constructor de la clase BinaryTree.
     */
    public BinaryTree(){
        root = null;
    }
    /**
     * Comprueba si el arbol está vacío.
     * @return 
     */
    public boolean isEmpty(){
        return (getRoot() == null);
    }
    /**
     * Comprueba si es la raíz.
     * @param givenLabel
     * @return 
     */
    private boolean isRoot(Comparable givenLabel){
        return (root.areEqualLabels(givenLabel));
    }
    /**
     * Modifica la raíz del árbol.
     * @param newNode 
     */
    private void setRoot(TreeNode<T> newNode){
        root = newNode;
    }
    /**
     * Devuelve la raíz del árbol.
     * @return 
     */
    private TreeNode<T> getRoot(){
        return root;
    }
    /**
     * Agrega un nodo al árbol.
     * @param newNode
     * @return 
     */
    public int insertNode(TreeNode<T> newNode){
        if(isEmpty()){
            setRoot(newNode);
            return 1;
        }else{
            return getRoot().insertNode(newNode);
        }
    }
    /**
     * Obtiene un nodo del árbol.
     * @param givenLabel
     * @return 
     */
    public TreeNode<T> searchNode(Comparable givenLabel){
        if(isEmpty()){
            return null;
        }else{
            return getRoot().searchNode(givenLabel);
        }
    }
    /**
     * Elimina un nodo del árbol.
     * @param givenLabel
     * @return 
     */
    public int deleteNode(Comparable givenLabel){
        if(isEmpty()){
            return 0;//Está vacio.
        }else{
            if (isRoot(givenLabel)){
                return -1;//No se puede eliminar la raíz ya que falta el balanceado.
            } else {
                getRoot().deleteNode(givenLabel);
                return 1;
            } 
        }
    }
    /**
     * Muestra el recorrido en orden del árbol.
     * @return 
     */
    public String pathInOrder(){
        if(isEmpty()){
            return "";
        }else{
            return getRoot().pathInOrder();
        }
    }
    /**
     * Obtiene todos los nodos del árbol.
     * @return 
     */
    public ArrayList<TreeNode<T>> getTreeNodes(){
        if(isEmpty()){
            return null;
        }else{
            return getRoot().getTreeNodes();
        }
    }
    /**
     * Obtiene todas las etiquetas del árbol.
     * @return 
     */
    public ArrayList<Comparable> getLabelsList(){
        if(isEmpty()){
            return null;
        }else{
            return getRoot().getLabelsList();
        }
    }
    /**
     * Obtiene todos los valores del árbol.
     * @return 
     */
    public ArrayList<T> getValuesList(){
        if(isEmpty()){
            return null;
        }else{
            return getRoot().getValuesList();
        }
    }
}
