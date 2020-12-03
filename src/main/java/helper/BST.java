package helper;

import helper.node.BSTNode;

public class BST {
    BSTNode root;

    BST() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public BSTNode insertRec(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);


        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(BSTNode root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " < ");
            inorderRec(root.right);
        }
    }
}