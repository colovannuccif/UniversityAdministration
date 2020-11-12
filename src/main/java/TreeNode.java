
import java.util.ArrayList;
/**
 *
 * @author colovannucci.f
 * @param <T>
 */
public class TreeNode<T> {
    private TreeNode<T> leftSon;
    private TreeNode<T> rightSon;
    private final Comparable label;
    private T value;
    private static final String ELEMENT_SEPARATOR = "-";
    /**
     * Constructor de la clase TreeNode.
     * @param tag
     * @param nodeValue 
     */
    public TreeNode(Comparable tag, T nodeValue){
        label = tag;
        value = nodeValue;
        leftSon = null;
        rightSon = null;
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
     * Devuelve el Hijo Izquierdo.
     * @return 
     */
    private TreeNode<T> getLeftSon(){
        return leftSon;
    }
    /**
     * Devuelve el Hijo Derecho.
     * @return 
     */
    private TreeNode<T> getRightSon(){
        return rightSon;
    }
    /**
     * Comprueba si tiene Hijo Izquierdo.
     * @return 
     */
    private boolean haveLeftSon(){
        return (leftSon != null);
    }
    /**
     * Comprueba si tiene Hijo Derecho.
     * @return 
     */
    private boolean haveRightSon(){
        return (rightSon != null);
    }
    /**
     * Comprueba si no tiene ningún hijo.
     * @return 
     */
    private boolean isLeaf(){
        return (!(haveLeftSon()) && !(haveRightSon()));
    }
    /**
     * Actualiza el Hijo Izquierdo.
     * @param newNode 
     */
    public void setLeftSon(TreeNode<T> newNode){
        newLeftSon(newNode);
    }
    /**
     * Modifica el Hijo Izquierdo.
     * @param newNode 
     */
    private void newLeftSon(TreeNode<T> newNode){
        leftSon = newNode;
    }
    /**
     * Actualiza el Hijo Derecho.
     * @param newNode 
     */
    public void setRightSon(TreeNode<T> newNode){
        newRightSon(newNode);
    }
    /**
     * Modifica el Hijo Derecho.
     * @param newNode 
     */
    private void newRightSon(TreeNode<T> newNode){
        rightSon = newNode;
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
     * Comprueba si la etiqueta dada es mayor.
     * @param givenLabel
     * @return 
     */
    private boolean isMajorLabel(Comparable givenLabel){
        return ((compareLabels(givenLabel)) < 0);
    }
    /**
     * Comprueba si la etiqueta dada es menor.
     * @param givenLabel
     * @return 
     */
    private boolean isMinorLabel(Comparable givenLabel){
        return ((compareLabels(givenLabel)) > 0);
    }
    /**
     * Agrega un nodo al árbol.
     * @param newNode
     * @return 
     */
    public int insertNode(TreeNode<T> newNode){
        return insert(newNode);
    }
    /**
     * Añade un nodo al árbol.
     * @param newNode
     * @return 
     */
    private int insert(TreeNode<T> newNode){
        if (areEqualLabels(newNode.getLabel())) {
            return -1;//Está repetido.
        } else if (isMajorLabel(newNode.getLabel())) {
            if (haveRightSon()) {
                this.getRightSon().insert(newNode);
            } else {
                this.setRightSon(newNode);
            }
        } else {
            if (haveLeftSon()) {
                this.getLeftSon().insert(newNode);
            } else {
                this.setLeftSon(newNode);
            }
        }
        return 1;
    }
    /**
     * Obtiene un nodo del árbol.
     * @param givenLabel
     * @return 
     */
    public TreeNode<T> searchNode(Comparable givenLabel){
        return search(givenLabel);
    }
    /**
     * Devuelve el nodo del árbol.
     * @param givenLabel
     * @return 
     */
    private TreeNode<T> search(Comparable givenLabel){
        if (areEqualLabels(givenLabel)) {
            return this;
        } else if (isMajorLabel(givenLabel)) {
            if (haveRightSon()) {
                return this.getRightSon().search(givenLabel);
            } else {
                return null;
            }
        } else {
            if (haveLeftSon()) {
                return this.getLeftSon().search(givenLabel);
            } else {
                return null;
            }
        }
    }
    /**
     * Elimina un nodo del árbol.
     * @param givenLabel 
     */
    public void deleteNode(Comparable givenLabel){
        selectNodeToRemove(givenLabel);
    }
    /**
     * Busca el nodo del árbol a eliminar.
     * @param givenLabel
     * @return 
     */
    private TreeNode<T> selectNodeToRemove(Comparable givenLabel){
        if (isMajorLabel(givenLabel)) {
            if (haveRightSon()) {
                this.setRightSon(this.getRightSon().selectNodeToRemove(givenLabel));
            }
            return this;
        }
        if (isMinorLabel(givenLabel)){
            if (haveLeftSon()) {
                this.setLeftSon(this.getLeftSon().selectNodeToRemove(givenLabel));
            }
            return this;
        }
        return this.removeNode();
    }
    /**
     * Quita un nodo del árbol.
     * @return 
     */
    private TreeNode<T> removeNode(){
        if (isLeaf()) {
            return null;
        }
        if (!(haveLeftSon())) {
            return this.getRightSon();
        }
        if (!(haveRightSon())) {
            return this.getLeftSon();
        }
        TreeNode<T> son = this.getLeftSon();
        TreeNode<T> father = this;
        while (son.haveRightSon()) {
            father = son;
            son = son.getRightSon();
        }
        if (father != this) {
            father.setRightSon(son.getLeftSon());
            son.setLeftSon(this.getLeftSon());

        }
        son.setRightSon(this.getRightSon());
        return son;
    }
    /**
     * Obtiene el recorrido en orden del árbol.
     * @return 
     */
    public String pathInOrder(){
        return inOrder();
    }
    /**
     * Devuelve el recorrido en orden del árbol.
     * @return 
     */
    private String inOrder(){
        StringBuilder nodeLabels = new StringBuilder();
        if (haveLeftSon()) {
            nodeLabels.append(this.getLeftSon().inOrder());
            nodeLabels.append(ELEMENT_SEPARATOR);
        }
        nodeLabels.append(this.getLabel());
        if (haveRightSon()) {
            nodeLabels.append(ELEMENT_SEPARATOR);
            nodeLabels.append(this.getRightSon().inOrder());
        }
        return nodeLabels.toString();
    }
    /**
     * Obtiene todos los nodos del árbol.
     * @return 
     */
    public ArrayList<TreeNode<T>> getTreeNodes(){
        ArrayList<TreeNode<T>> treeNodes = new ArrayList();
        return returnTreeNodes(treeNodes);
    }
    /**
     * Devuelve todos los nodos del árbol.
     * @param givenArray
     * @return 
     */
    private ArrayList<TreeNode<T>> returnTreeNodes(ArrayList<TreeNode<T>> givenArray){
        ArrayList<TreeNode<T>> treeNodes = givenArray;
        if (haveLeftSon()) {
            this.getLeftSon().returnTreeNodes(treeNodes);
        }
        treeNodes.add(this);
        if (haveRightSon()) {
            this.getRightSon().returnTreeNodes(treeNodes);
        }
        return treeNodes;
    }
    /**
     * Obtiene todas las etiquetas del árbol.
     * @return 
     */
    public ArrayList<Comparable> getLabelsList(){
        return returnLabelsList();
    }
    /**
     * Devuelve todas las etiquetas del árbol.
     * @return 
     */
    private ArrayList<Comparable> returnLabelsList(){
        ArrayList<TreeNode<T>> treeNodes = new ArrayList();
        ArrayList<Comparable> labelsList = new ArrayList();
        for (TreeNode<T> node : returnTreeNodes(treeNodes)){
            labelsList.add(node.getLabel());
        }
        return labelsList;
    }
    /**
     * Obtiene todos los valores del árbol.
     * @return 
     */
    public ArrayList<T> getValuesList(){
        return returnValuesList();
    }
    /**
     * Devuelve todos los valores del árbol.
     * @return 
     */
    private ArrayList<T> returnValuesList(){
        ArrayList<TreeNode<T>> treeNodes = new ArrayList();
        ArrayList<T> valuesList = new ArrayList();
        for (TreeNode<T> node : returnTreeNodes(treeNodes)){
            valuesList.add(node.getValue());
        }
        return valuesList;
    }
}
