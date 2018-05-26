package mollychin.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Mollychin on 2018/4/15.
 */
public class BSTree<T extends Comparable<? super T>> {

  private static class BinaryNode<T> {

    BinaryNode(T theElement) {
      this(theElement, null, null);
    }

    BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt) {
      element = theElement;
      left = lt;
      right = rt;
    }

    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;
  }

  private BinaryNode<T> root;

  public boolean isEmpty() {
    return root == null;
  }

  public void insert(T x) {
    root = insert(x, root);
  }

  private BinaryNode<T> insert(T x, BinaryNode<T> t) {
    if (t == null) {
      return new BinaryNode<>(x, null, null);
    }

    int compareResult = x.compareTo(t.element);

    if (compareResult < 0) {
      t.left = insert(x, t.left);
    } else if (compareResult > 0) {
      t.right = insert(x, t.right);
    } else {
      ;
    }
    return t;
  }

  /**
   * 前序遍历 递归
   */
  public void preOrder(BinaryNode<T> Node) {
    if (Node != null) {
      System.out.print(Node.element + " ");
      preOrder(Node.left);
      preOrder(Node.right);
    }
  }

  /**
   * 中序遍历 递归
   */
  public void midOrder(BinaryNode<T> Node) {
    if (Node != null) {
      midOrder(Node.left);
      System.out.print(Node.element + " ");
      midOrder(Node.right);
    }
  }

  /**
   * 后序遍历 递归
   */
  public void posOrder(BinaryNode<T> Node) {
    if (Node != null) {
      posOrder(Node.left);
      posOrder(Node.right);
      System.out.print(Node.element + " ");
    }
  }

  /*
   * 层序遍历
   * 递归
   */
  public void levelOrder(BinaryNode<T> Node) {
    if (Node == null) {
      return;
    }

    int depth = depth(Node);

    for (int i = 1; i <= depth; i++) {
      levelOrder(Node, i);
    }
  }

  private void levelOrder(BinaryNode<T> Node, int level) {
    if (Node == null || level < 1) {
      return;
    }

    if (level == 1) {
      System.out.print(Node.element + "  ");
      return;
    }

    // 左子树
    levelOrder(Node.left, level - 1);

    // 右子树
    levelOrder(Node.right, level - 1);
  }

  public int depth(BinaryNode<T> Node) {
    if (Node == null) {
      return 0;
    }

    int l = depth(Node.left);
    int r = depth(Node.right);
    if (l > r) {
      return l + 1;
    } else {
      return r + 1;
    }
  }

  /**
   * 前序遍历 非递归
   */
  public void preOrder1(BinaryNode<T> Node) {
    Stack<BinaryNode> stack = new Stack<>();
    while (Node != null || !stack.empty()) {
      while (Node != null) {
        System.out.print(Node.element + "   ");
        stack.push(Node);
        Node = Node.left;
      }
      if (!stack.empty()) {
        Node = stack.pop();
        Node = Node.right;
      }
    }
  }

  /**
   * 中序遍历 非递归
   */
  public void midOrder1(BinaryNode<T> Node) {
    Stack<BinaryNode> stack = new Stack<>();
    while (Node != null || !stack.empty()) {
      while (Node != null) {
        stack.push(Node);
        Node = Node.left;
      }
      if (!stack.empty()) {
        Node = stack.pop();
        System.out.print(Node.element + "   ");
        Node = Node.right;
      }
    }
  }

  /**
   * 后序遍历 非递归
   */
  public void posOrder1(BinaryNode<T> Node) {
    Stack<BinaryNode> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int i = 1;
    while (Node != null || !stack1.empty()) {
      while (Node != null) {
        stack1.push(Node);
        stack2.push(0);
        Node = Node.left;
      }

      while (!stack1.empty() && stack2.peek() == i) {
        stack2.pop();
        System.out.print(stack1.pop().element + "   ");
      }

      if (!stack1.empty()) {
        stack2.pop();
        stack2.push(1);
        Node = stack1.peek();
        Node = Node.right;
      }
    }
  }

  /*
   * 层序遍历
   * 非递归
   */
  public void levelOrder1(BinaryNode<T> Node) {
    if (Node == null) {
      return;
    }

    BinaryNode<T> binaryNode;
    Queue<BinaryNode> queue = new LinkedList<>();
    queue.add(Node);

    while (queue.size() != 0) {
      binaryNode = queue.poll();

      System.out.print(binaryNode.element + "  ");

      if (binaryNode.left != null) {
        queue.offer(binaryNode.left);
      }
      if (binaryNode.right != null) {
        queue.offer(binaryNode.right);
      }
    }
  }

  public static void main(String[] args) {
    int[] input = {4, 2, 6, 1, 3, 5, 7, 8, 10};
    BSTree<Integer> tree = new BSTree<>();
    for (int i = 0; i < input.length; i++) {
      tree.insert(input[i]);
    }
    System.out.print("递归前序遍历 ：");
    tree.preOrder(tree.root);
    System.out.print("\n非递归前序遍历：");
    tree.preOrder1(tree.root);
    System.out.print("\n递归中序遍历 ：");
    tree.midOrder(tree.root);
    System.out.print("\n非递归中序遍历 ：");
    tree.midOrder1(tree.root);
    System.out.print("\n递归后序遍历 ：");
    tree.posOrder(tree.root);
    System.out.print("\n非递归后序遍历 ：");
    tree.posOrder1(tree.root);
    System.out.print("\n递归层序遍历：");
    tree.levelOrder(tree.root);
    System.out.print("\n非递归层序遍历 ：");
    tree.levelOrder1(tree.root);
  }
}
