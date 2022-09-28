package org.drout.das.tree.ex11;

import java.util.*;

public class BinaryTree {

    /* =============================
     * Depth First:
     * Inorder (Left, Root, Right)
     * Preorder (Root, Left, Right)
     * Postorder (Left, Right, Root)
     * =============================
     * Breadth First:
     * Level Order Traversal
     * =============================
     *       1
     *    2    3
     *  4  5  6  7
     *
     * =============================
     * */

    public static final List<Integer> treeInorderValues = new ArrayList<>();
    public static final List<Integer> treePreorderValues = new ArrayList<>();
    public static final List<Integer> treePostorderValues = new ArrayList<>();

    private static Node treeRoot;

    public static void createBT() {

        treeRoot = new Node(1);

        treeRoot.left = new Node(2);
        treeRoot.right = new Node(3);

        treeRoot.left.left = new Node(4);
        treeRoot.left.right = new Node(5);

        treeRoot.right.left = new Node(6);
        treeRoot.right.right = new Node(7);
        treeRoot.right.right.left = new Node(8);
    }

    public static void main(String[] arrays) {
        createBT();
        inorderDFT(treeRoot);
        System.out.println(treeInorderValues);

        preorderDFT(treeRoot);
        System.out.println(treePreorderValues);

        postorderDFT(treeRoot);
        System.out.println(treePostorderValues);

        levelOrderBFT(treeRoot);

        System.out.println(checkTreeMaximumHeight(treeRoot));
    }


    public static void inorderDFT(Node currentNode) {
        if (currentNode == null) {
            return;
        } else {
            inorderDFT(currentNode.left);
            treeInorderValues.add(currentNode.data);
            inorderDFT(currentNode.right);
        }
    }


    public static void preorderDFT(Node currentNode) {
        if (currentNode == null) {
            return;
        } else {
            treePreorderValues.add(currentNode.data);
            preorderDFT(currentNode.left);
            preorderDFT(currentNode.right);
        }
    }


    public static void postorderDFT(Node currentNode) {
        if (currentNode == null) {
            return;
        } else {
            postorderDFT(currentNode.left);
            postorderDFT(currentNode.right);
            treePostorderValues.add(currentNode.data);
        }
    }

    public static void levelOrderBFT(Node rootNode) {
        ArrayList<Integer> nodeValues = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            nodeValues.add(currentNode.data);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        System.out.println(nodeValues);
    }

    int treeLevelHeight(Node node) {
        if (node == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        int height = 0;

        while (1 == 1) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;
            while (nodeCount > 0) {
                Node currentNode = queue.peek();
                queue.remove();
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
                nodeCount--;
            }
        }
    }

    public static int checkTreeMaximumHeight(Node currentNode) {
        if (currentNode == null)
            return -1;
        else {
            int leftDepth = checkTreeMaximumHeight(currentNode.left);
            int rightDepth = checkTreeMaximumHeight(currentNode.right);
            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }
    }

}
