package com.company;

import java.util.ArrayDeque;
import java.util.Stack;

public class MyBST {
    public Node root;

    public void add(Object itemToAdd) {
        Node  newNode = new Node(itemToAdd);
        if(root == null) {
            root = newNode;
        }
        else {
            Node current = root;
            Node parent;
            while(true) {
                parent = current;
               
                if((Integer)(itemToAdd) < (Integer)(current.val)) {
                    current = current.leftChild;
                    
                    if(current == null) {
                      
                        parent.leftChild = newNode;
                        return;
                    }

                }
                
                else {
                    current = current.rightChild;
                    
                    if(current == null) {
                       
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }// end of while(true)
        }
    }

    public void remove(Object value) {
        Node current = root;
        Node parent = root;
        boolean isLeft = false;
        boolean isRight = false;
        
        while(current.val != value) {
            parent = current;
            isLeft = false;
            isRight = false;
            if((Integer)value < (Integer)current.val) {
                current = current.leftChild;
                isLeft = true;
            }
            else {
                current = current.rightChild;
                isRight = true;
            }
        }
        
        if((current.leftChild == null)
                && (current.rightChild == null)) {
            System.out.println("It's a leaf node, there are no child nodes");
            if(isLeft) {
               
                parent.leftChild = null;
            }
            else if(isRight) {
             
                parent.rightChild = null;
            }
        }
        
        else if((current.leftChild != null)
                && (current.rightChild == null)) {
            System.out.println("It's not a leaf node, there are left child nodes");

            if(isLeft) {
                parent.leftChild = current.leftChild;
            }
            else if(isRight) {
                parent.rightChild = current.leftChild;
            }
            current = null;
        }

       
        else if((current.leftChild == null)
                && (current.rightChild != null)) {
            System.out.println("It's not a leaf node, there are right child nodes");
            if(isLeft) {
                parent.leftChild = current.rightChild;

            }
            else if(isRight) {
                parent.rightChild = current.rightChild;
            }
            current = null;
        }
      
        else {
            System.out.println("It's not a leaf node, there are left and right child nodes");

            if(isLeft) {
                parent.leftChild = current.rightChild;

                Node currentLeft = current.rightChild;
                Node parentLeft = currentLeft;
                while(currentLeft != null) {
                    parentLeft = currentLeft;
                    currentLeft = currentLeft.leftChild;
                }
                parentLeft.leftChild = current.leftChild;
                current = null;

            }
            else if(isRight) {
                parent.rightChild = current.rightChild;

                Node currentLeft = current.rightChild;
                Node parentLeft = currentLeft;
                while(currentLeft != null) {
                    parentLeft = currentLeft;
                    currentLeft = currentLeft.leftChild;
                }
                parentLeft.leftChild = current.leftChild;
                current = null;
            }
        }
    }

    public void preOrderTraversal(Node localNode) {

        if(localNode != null) {
            System.out.println(localNode.val);
            preOrderTraversal(localNode.leftChild);
            preOrderTraversal(localNode.rightChild);
        }
    }

    public Node find(Object objectToFind) {
        Node current = root;

        while(current.val != (Integer)objectToFind) {

            if((Integer)objectToFind < (Integer)current.val) {
                current = current.leftChild;
            }
            else {
                current = current.rightChild;
            }
            if(current == null) {
                return null;
            }
        }

        return current;
    }

    public void inOrderTraversal(Node localNode) {

        if(localNode != null) {

            inOrderTraversal(localNode.leftChild);
            System.out.println(localNode.val);
            inOrderTraversal(localNode.rightChild);

        }
    }

    public void postOrderTraversal(Node localNode) {

        if(localNode != null) {
            postOrderTraversal(localNode.leftChild);
            postOrderTraversal(localNode.rightChild);
            System.out.println(localNode.val);
        }
    }

    public void breadthFirstSearch(Node node) {
        if(node==null){
            System.out.print("empty tree");
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<Node>();
        deque.add(node);
        while(!deque.isEmpty()){
            Node rnode = deque.remove();
            System.out.print(rnode.val+"  ");
            if(rnode.leftChild!=null){
                deque.add(rnode.leftChild);
            }
            if(rnode.rightChild!=null){
                deque.add(rnode.rightChild);
            }
        }
    }

    public void clear(Node root) {
        if (root==null)
            return ;

        if (root.leftChild != null)
            clear(root.leftChild);
        if (root.rightChild != null)
            clear(root.rightChild);

        root.leftChild = null;
        root.rightChild = null;
        this.root=null;
    }

    public int size(Node root) {
        if(root==null){
            return 0;
        }

        return 1+size(root.leftChild)+size(root.rightChild);
    }

    public class Node {
        Object   val;
        Node  leftChild;
        Node  rightChild;

        Node(Object val) {
            this.val = val;
        }
        public void  printNode() {
            System.out.println(val);
        }
    }
}