public class BinarySearchTreeWithRotate<E extends Comparable<E>>
    extends BinarySearchTree<E> {
    // Methods
    /**
      Method to perform right rotation
      pre:  root is the root of a binary search tree
      post: root.right is the root of a binary search tree
         root.right.right is raised one level,
         root.right.left does not change levels,
         root.left is lowered one level,
         the new root is returned
       @param localRoot
          The root of the binary tree to be rotated
       @return
          The new root of the rotated tree
     */
     protected Node <E> rotateRight(Node <E> localRoot) {
		 Node<E> temp = localRoot.left;
		 localRoot.left = temp.right;
		 temp.right = localRoot;
		 return temp;
     }

     // TO BE COMPLETED BY THE STUDENT INCLUDING THE javadoc COMMENTS
     // REFER TO PAGE # 476 IN YOUR BOOK
     protected Node <E> rotateLeft(Node <E> localRoot) {
	 		 return null;
     }
}


