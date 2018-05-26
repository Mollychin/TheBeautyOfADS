package mollychin.tree;

/**
 * Created by Mollychin on 2018/4/15.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

  public BNode find(int key){
    if(root == null){
      System.out.println("The tree is empty!");
      return null;
    }
    BNode current = root;
//    while(current.element != key){
//      if(key > current.element())
//        current = current.right;
//      else
//        current = current.left;
//      if(current == null)
//        return null;
//    }
    return current;
  }

  /**
   * 用以测试二叉树.
   */
  public static void main(String[] args) {
    int[] nodes = {4, 2, 6, 1, 3, 5, 7, 8, 10};
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    // 插入结点值
    for (int i = 0; i < nodes.length; i++) {
      tree.insert(nodes[i]);
    }
    // 前序遍历结果：
    System.out.println("前序遍历：");
    preOrder(tree.root);
    System.out.println();
    // 中序遍历结果：
    System.out.println("中序遍历：");
    midOrder(tree.root);
    System.out.println();
    // 后续遍历结果：
    System.out.println("后序遍历：");
    postOrder(tree.root);
  }

  /**
   * 前序遍历.
   */
  private static void preOrder(BNode<Integer> node) {
    if (node != null) {
      System.out.print(node.getElement() + "  ");
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  /**
   * 中序遍历.
   */
  private static void midOrder(BNode<Integer> node) {
    if (node != null) {
      midOrder(node.left);
      System.out.print(node.getElement() + "  ");
      midOrder(node.right);
    }
  }

  /**
   * 后序遍历.
   */
  private static void postOrder(BNode<Integer> node) {
    if (node != null) {
      postOrder(node.left);
      postOrder(node.right);
      System.out.print(node.getElement() + "  ");
    }
  }

  /**
   * 插入节点.
   */
  private void insert(T node) {
    root = insert(node, root);
  }

  /**
   * 插入结点的具体实现.
   */
  private BNode<T> insert(T node, BNode<T> t) {
    if (t == null) {
      return new BNode<T>(node, null, null);
    }
    int compareResult = node.compareTo(t.getElement());
    if (compareResult < 0) {
      t.left = insert(node, t.left);
    } else if (compareResult > 0) {
      t.right = insert(node, t.right);
    } else {
      ;
    }
    return t;
  }


  /**
   * 根节点.
   */
  private BNode<T> root;

  /**
   * 二叉树的内部类，每一个节点的定义.
   */
  private static class BNode<T> {

    private T element;
    BNode<T> right;
    BNode<T> left;

    /**
     * 节点类的构造函数1.
     */
    BNode(T element, BNode<T> right, BNode<T> left) {
      this.setElement(element);
      this.right = right;
      this.left = left;
    }

    /**
     * 节点类的构造函数2.
     */
    BNode(T element) {
      this.setElement(element);
    }

    public void setElement(T element) {
      this.element = element;
    }

    public T getElement() {
      return element;
    }
  }
}
