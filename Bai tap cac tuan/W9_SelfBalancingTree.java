
import java.util.Scanner;

public class W9_SelfBalancingTree {

    static class Node {
        int val;
        int ht;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.ht = 0;
            this.left = null;
            this.right = null;
        }
    }

    static int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.ht;
    }

    static int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    static void updateHeight(Node node) {
        node.ht = 1 + Math.max(
                height(node.left),
                height(node.right)
        );
    }

    static Node rightRotate(Node y) {

        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    static Node leftRotate(Node x) {

        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    static Node insert(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        }
        else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        else {
            return root;
        }

        updateHeight(root);

        int balance = getBalance(root);


        // LL Case
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

        // RR Case
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        // LR Case
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL Case
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Duyệt cây Preorder
    static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        preorder(root.left);
        preorder(root.right);
    }

    static void printHeight(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(
                "Node: " + root.val +
                        " | Height: " + root.ht +
                        " | BF: " + getBalance(root)
        );

        printHeight(root.left);
        printHeight(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node root = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        System.out.println("Preorder:");
        preorder(root);

        System.out.println("\n\nNode information:");
        printHeight(root);

        sc.close();
    }
}
