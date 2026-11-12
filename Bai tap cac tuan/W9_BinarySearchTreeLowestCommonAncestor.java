import java.util.Scanner;

public class W9_BinarySearchTreeLowestCommonAncestor {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static Node lca(Node root, int v1, int v2) {

        while (root != null) {

            if (v1 < root.data && v2 < root.data) {
                root = root.left;
            }
            else if (v1 > root.data && v2 > root.data) {
                root = root.right;
            }
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node root = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            root = insert(root, data);
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        Node result = lca(root, v1, v2);

        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("Not found");
        }

        sc.close();
    }
}