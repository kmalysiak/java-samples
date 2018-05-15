package pl.coderstrust.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {

    private Node root = null;
    private List<Integer> traverseOutput;

    public boolean add(int newKey) {
        Node newNode = new Node(newKey);
        if (root == null) {
            root = newNode;
            root.nodeType = NodeType.ROOT;
            return true;
        } else {
            Node currentNode = root;
            while (true) {
                Node parentNode = currentNode;
                if (newKey < currentNode.data) {
                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        parentNode.replaceChild(NodeType.LEFT_CHILD, newNode);
                        return true;
                    }
                } else {
                    if (newKey > currentNode.data) {
                        currentNode = currentNode.right;
                        if (currentNode == null) {
                            parentNode.replaceChild(NodeType.RIGHT_CHILD, newNode);
                            return true;
                        }
                    }
                    if (newKey == currentNode.data) {
                        return false;
                    }
                }
            }
        }
    }

    public boolean find(int key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.data == key) {
                return true;
            } else {
                if (currentNode.data > key) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return false;
    }

    public boolean delete(int key) {
        Node parentNode = root;
        Node currentNode = root;
        while (currentNode.data != key) {
            parentNode = currentNode;
            if (currentNode.data > key) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
            if (currentNode == null) {
                return false;
            }
        }
        switch (currentNode.children) {
            case HAS_NONE:
                if (currentNode == root) {
                    root = null;
                } else {
                    parentNode.replaceChild(currentNode, null);
                }
                break;
            case HAS_LEFT:
                if (currentNode == root) {
                    root = currentNode.left;
                    root.nodeType = NodeType.ROOT;
                } else {
                    parentNode.replaceChild(currentNode, currentNode.left);
                }
                break;
            case HAS_RIGHT:
                if (currentNode == root) {
                    root = currentNode.right;
                    root.nodeType = NodeType.ROOT;
                } else {
                    parentNode.replaceChild(currentNode, currentNode.right);
                }
            case HAS_BOTH:
                Node successor = prepareSuccessor(currentNode);
                if (currentNode == root) {
                    root = successor;
                    root.nodeType = NodeType.ROOT;
                } else {
                    parentNode.replaceChild(currentNode, successor);
                }
                successor.replaceChild(NodeType.LEFT_CHILD, currentNode.left);
                break;
        }
        currentNode = null;
        return true;
    }

    private Node prepareSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != deleteNode.right) {
            successorParent.replaceChild(successorParent.left, successor.right);
            successor.replaceChild(NodeType.RIGHT_CHILD, deleteNode.right);
        }
        return successor;
    }

    public int[] traverseInOrder() {
        traverseOutput = new ArrayList<>();
        return traverse(root, ORDER.INORDER);

    }

    public int[] traversePreOrder() {
        traverseOutput = new ArrayList<>();
        return traverse(root, ORDER.PREORDER);

    }

    public int[] traversePostOrder() {
        traverseOutput = new ArrayList<>();
        return traverse(root, ORDER.POSTORDER);
    }


    private int[] traverse(Node node, ORDER order) {
        if (node == null) {
            return new int[0];
        }
        switch (order) {
            case PREORDER:
                traverseOutput.add(node.data);
                traverse(node.left, order);
                traverse(node.right, order);
                break;
            case INORDER:
                traverse(node.left, order);
                traverseOutput.add(node.data);
                traverse(node.right, order);
                break;
            case POSTORDER:
                traverse(node.left, order);
                traverse(node.right, order);
                traverseOutput.add(node.data);
                break;
        }
        return traverseOutput.stream().mapToInt(i -> i).toArray();
    }


    private  enum NodeType {
        ROOT, LEFT_CHILD, RIGHT_CHILD
    }

    private enum Children {
        HAS_LEFT, HAS_RIGHT, HAS_BOTH, HAS_NONE
    }

    private enum ORDER {
        PREORDER, INORDER, POSTORDER
    }

    class Node {
        public int data;
        public Node left = null;
        public Node right = null;
        private NodeType nodeType;
        private Children children = Children.HAS_NONE;

        public Node(int data) {
            this.data = data;
        }

        public void replaceChild(NodeType nodeType, Node newChild) {
            if (nodeType == NodeType.LEFT_CHILD) {
                left = newChild;
                if (newChild != null) {
                    newChild.nodeType = NodeType.LEFT_CHILD;
                }
            } else {
                right = newChild;
                if (newChild != null) {
                    newChild.nodeType = NodeType.RIGHT_CHILD;
                }
            }
            updateChildrenInfo();
        }

        public void replaceChild(Node currentChild, Node newChild) {
            if (currentChild.nodeType == NodeType.LEFT_CHILD) {
                replaceChild(NodeType.LEFT_CHILD, newChild);
            } else {
                replaceChild(NodeType.RIGHT_CHILD, newChild);
            }
        }

        private void updateChildrenInfo() {
            if (left == null && right == null) {
                children = Children.HAS_NONE;
            } else {
                if (left != null && right != null) {
                    children = Children.HAS_BOTH;
                } else {
                    if (left != null) {
                        children = Children.HAS_LEFT;
                    } else {
                        children = Children.HAS_RIGHT;
                    }

                }
            }
        }
    }
}

