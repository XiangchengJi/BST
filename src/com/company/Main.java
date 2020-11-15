package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyBST bst = new MyBST();
        bst.add(9);
        bst.add(19);
        bst.add(12);
        bst.add(3);
        bst.remove(19);
        bst.add(7);
        bst.clear(bst.root);
        bst.add(14);
        bst.add(21);
        bst.add(6);
        bst.add(1);
        bst.add(18);
        bst.add(4);
        bst.remove(18);
        System.out.println(bst.size(bst.root));
        System.out.println(bst.find(18));
        System.out.println(bst.find(14));
//        bst.preOrderTraversal(bst.root);
//        bst.postOrderTraversal(bst.root);
//        bst.inOrderTraversal(bst.root);
        bst.breadthFirstSearch(bst.root);

    }
}
