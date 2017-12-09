public class BinarySearchTree <E extends Comparable <E>>
        extends BinaryTree <E> implements SearchTree <E> {
   // denotes whether the addition is successful
   protected boolean addReturn;

   /**
     Constructor - initializes the tree to an empty tree
     */
   public BinarySearchTree () {
      super() ;
   }

   public BinarySearchTree(E data, BinarySearchTree <E> left,
          BinarySearchTree <E> right)  {
	   super(data, left, right);
   }

   /**
     Searches for a given element in the binary search tree
     @param
           target element to be searched
     @param
           count - to keep track of the comparisons made for this
                   find operations
     @return
           the object if it is found in the tree; null
                     otherwise
    */
 
   public E find (E target, IntObject count) {
	   
	 return find(target, count, root);
	 
   }
  
   /**
    * 
    * @param target element to be searched
    * @param count to keep track of the comparisons made for this find operations
    * @param node - the element the target is compared to
    * @return the object if it is found in the tree; null otherwise
    */
   private E find(E target, IntObject count, Node <E> node)
   {
	   if (node == null)
		   return null;

	  int compResult = target.compareTo(node.data);
	   
	   
	   //if (target.equals(node.data)) 
			  
	  if (compResult == 0)
	   {
		   count.setData(count.getData()+1);
		   return node.data;
		}
	  
	  //if (target.compareTo(node.data) < 0)
		
	  if (compResult < 0)
	   {
		   count.setData(count.getData()+1);
		   return find(target, count, node.left);
	   }
	   else
	   {
		   count.setData(count.getData()+1);
		   return find(target, count, node.right);
	   }
   }

   /**
     inserts an element into a BST
     @param
           item element that needs to be inserted
     @return true if the insertion is successful, false otherwise
    */
    // Complexity: O(h) - where h is the height of the tree.
    // In the worst case it could be O(n).  But on aveage
    // we can expect a complexity of O(log n)
    public boolean add(E item) {
	   root = add(root, item);
	   return addReturn;
   }

   private Node <E> add (Node <E> localRoot, E item) {
	   if (localRoot == null) {
		   addReturn = true;
		   return new Node<E> (item);
       }

       int compareResult = item.compareTo(localRoot.data);
       if (compareResult == 0) {
		   // item is already in the tree.
		   addReturn = false;
		   return localRoot;
       }

       if (compareResult < 0) {
		   // item has to go in the left subtree of localRoot
		   localRoot.left = add(localRoot.left, item);
		   return localRoot;
       }

       else {
		    // item has to go in the left subtree of localRoot
		    localRoot.right = add(localRoot.right, item);
		    return localRoot;
       }
   }

   /** @return the minimum element in the Set */
   public E first() {
      return first(root);
   }
   
   private E first(Node <E> node)
   {
	   if (node.left == null)
		   return node.data;
	   else return first(node.left);
   }

   /** @return the maximum element in the Set */
   public E last() 
   {
      	return last(root);
   }
   
   private E last(Node <E> node)
   {
	   if (node.right == null)
		   return node.data;
	   else return last(node.right);
   }
   
}
