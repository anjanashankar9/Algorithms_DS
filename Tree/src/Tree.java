import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class creates a node with two children pointers and a data of type T
 * @param <T>
 */
class TreeNode<T>{
	TreeNode<T> lChild;
	TreeNode<T> rChild;
	T data;

	public TreeNode(T data){
		this.data = data;
		lChild = null;
		rChild = null;
	}

	public TreeNode(T data, TreeNode<T> lChild,TreeNode<T> rChild){
		this.data = data;
		this.lChild = lChild;
		this.rChild = rChild;
	}

	public T getData(){
		return this.data;
	}
	public TreeNode<T> getlChild(){
		return this.lChild;
	}
	public TreeNode<T> getrChild(){
		return this.rChild;
	}

	//Setters
	public void setData(T data){
		this.data = data;
	}

	public void setlChild(TreeNode<T> lChild){
		this.lChild = lChild;
	}
	public void setrChild(TreeNode<T> rChild){
		this.rChild = rChild;
	}
}

/**
 * Class for Tree operations
 * @param <T>
 */
public class Tree<T extends Comparable<T>>{
	public TreeNode<T> root;

	public Tree(){
		root = null;
	}

	/**
	 * Insert a new node in the tree
	 * @param key key to be inserted
	 */
	public void insert(T key){
		root = insert(root,key);
	}

	/**
	 * Insert a new node in the subtree starting at node
	 * @param node Root node of subtree
	 * @param key key to be inserted
	 * @return The new TreeNode in the tree
	 */
	public TreeNode<T> insert(TreeNode<T> node,T key){
		if(node == null)
			return new TreeNode<T>(key);
		if(node.getData().compareTo(key) > 0){
			node.setlChild(insert(node.getlChild(),key));
			return node;
		}
		else{
			node.setrChild(insert(node.getrChild(),key));
			return node;
		}
	}

	/**
	 * Search operation on BST
	 * @param key key to be searched
	 * @return A boolean value indicating whether the key is present or not
	 */
	public boolean find(Integer key){
		return find(root,key);
	}

	/**
	 * Searches for the key in the subtree rooted at node
	 * @param node
	 * @param key
	 * @return
	 */
	public boolean find(TreeNode<T> node, Integer key){
		if(node == null)
			return false;
		if(node.getData().equals(key))
			return true;
		if(key.compareTo((Integer) node.getData()) < 0){
			return find(node.getlChild(),key);
		}
		return find(node.getrChild(),key);
	}

	/**
	 * Recursive inorder traversal
	 */
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}

	/**
	 * Recursive inorder traversal of the subtree rooted at node
	 * @param node
	 */
	public void inOrderTraversal(TreeNode<T> node){
		if(node == null)
			return;
		inOrderTraversal(node.getlChild());
		System.out.print(node.getData()+" , ");
		inOrderTraversal(node.getrChild());
	}

	/**
	 * Iterative inorder traversal using Stack
	 */
	public void inOrderTraversalIter(){
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		TreeNode<T> current = root;
		while(!s.empty() || current !=null){
			if(current !=null){
				s.push(current);
				current = current.getlChild();
			}
			else{
				TreeNode<T> node = s.pop();
				System.out.print(node.getData()+" , ");
				current = node.getrChild();
			}
		}
	}

	/**
	 * Recursive preorder traversal
	 */
	public void preOrderTraversal(){
		preOrderTraversal(root);
	}

	/**
	 * Recursive preorder traversal of the subtree rooted at node
	 * @param node
	 */
	public void preOrderTraversal(TreeNode<T> node){
		if(node == null)
			return;
		System.out.print(node.getData()+" , ");
		preOrderTraversal(node.getlChild());
		preOrderTraversal(node.getrChild());
	}

	/**
	 * Iterative Preorder traversal
	 */
	public void preOrderTraversalIter(){
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		TreeNode<T> current = root;
		while(!s.empty() || current!=null){
			if(current !=null){
				System.out.print(current.getData()+" , ");
				s.push(current);
				current = current.getlChild();
			}
			else{
				TreeNode<T> node = s.pop();
				current = node.getrChild();
			}
		}
	}

	/**
	 * Recursive Postorder traversal
	 */
	public void postOrderTraversal(){
		postOrderTraversal(root);
	}

	/**
	 * Recursive post order traversal of the subtree rooted at node
	 * @param node
	 */
	public void postOrderTraversal(TreeNode<T> node){
		if(node == null)
			return;
		postOrderTraversal(node.getlChild());
		postOrderTraversal(node.getrChild());
		System.out.print(node.getData() + " , ");
	}

	/**
	 * Iterative post order traversal
	 */
	public void postOrderTraversalIter(){
		Stack <TreeNode<T>> s = new Stack<TreeNode<T>>();
		s.push(root);
		TreeNode<T> current = root;
		TreeNode<T> prev = null;
		while(!s.empty()){
			current = s.peek();
			if(prev ==null || prev.getlChild() == current || prev.getrChild() == current){
				if(current.getlChild() != null)
					s.push(current.getlChild());
				else if(current.getrChild() != null){
					s.push(current.getrChild());
				}
			}
			else if(current.getlChild() == prev){
				//traversing up from left child, push right child
				if(current.getrChild() !=null){
					s.push(current.getrChild());
				}
			}
			else{
				s.pop();
				System.out.print(current.getData()+" , ");
			}
			prev = current;
		}

	}

	/**
	 * Level order traversal or Breadth First traversal
	 * Uses the inbuilt queue
	 */
	public void levelOrderTraversal(){
		Queue<TreeNode<T>> q = new LinkedList<TreeNode<T>>();
		q.add(root);
		while(q.size()>0){
			TreeNode<T> node = q.remove();
			System.out.print(node.getData()+" , ");
			if(node.getlChild() != null){
				q.add(node.getlChild());
			}
			if(node.getrChild() != null){
				q.add(node.getrChild());
			}
		}
	}

	/**
	 * Gets the number of nodes in the tree
	 * @return
	 */
	public int getSize(){
		return getSize(root);
	}

	/**
	 * Gets the size of subtree rooted at node
	 * @param node
	 * @return
	 */
	public int getSize(TreeNode<T> node){
		if(node == null)
			return 0;
		return (1+getSize(node.getlChild())+getSize(node.getrChild()));
	}

	/**
	 * Gets the height of the tree
	 * @return
	 */
	public int getHeight(){
		return getHeight(root);
	}

	/**
	 * Gets the height of subtree rooted at node
	 * @param node
	 * @return
	 */
	public int getHeight(TreeNode<T> node){
		if(node == null)
			return 0;
		return (1+Math.max(getHeight(node.getlChild()), getHeight(node.getrChild())));
	}

	/**
	 * Finds the successor of the node
	 * @param node
	 * @return
	 */
	public TreeNode<T> findSuccessor(TreeNode<T> node){
		//Return the smallest vaue rooted at node
		if(node == null)
			return null;
		else if(node.getlChild() == null)
			return node;
		else
			return findSuccessor(node.getlChild());

	}

    /**
     * Finds the least common ancestor of node 1 and node2
     */
    public TreeNode<T> findLCA(T n1, T n2) {
        return findLCA(root, n1, n2);
    }

    private TreeNode<T> findLCA(TreeNode<T> node, T n1, T n2) {
        if (node == null) {
            return null;
        }

        if (node.getData() == n1 || node.getData() == n2) {
            return node;
        }

        TreeNode left_LCA = findLCA(node.getlChild(), n1, n2);
        TreeNode right_LCA = findLCA(node.getrChild(), n1, n2);

        if (left_LCA != null & right_LCA != null) {
            return node;
        }

        return (left_LCA != null) ? left_LCA : right_LCA;
    }


    /**
	 * Finds predecessor
	 * @param node
	 * @return
	 */
	public TreeNode<T> findPredecessor(TreeNode<T> node){
		if(node == null)
			return null;
		else if(node.getrChild() == null)
			return node;
		else
			return findPredecessor(node.getrChild());
	}

	//Reference: http://geeksquiz.com/binary-search-tree-set-2-delete/
	/**
	 * When a node is deleted from a BST, three possibilities arise.
	 * 1. Node to be deleted is leaf
	 * 2. Node to be deleted has one child
	 * 3. Node to be deleted has two children
	 */
	public void remove(T key){
		root = remove(root,key);
	}

	/**
	 * Deletes the node from the subtree rooted at node
	 * @param node
	 * @param key
	 * @return
	 */
	public TreeNode<T> remove(TreeNode<T> node,T key){
		if (node == null)
			return node;
		if(node.getData().equals(key)){
			//node is found
			if(node.getlChild() == null && node.getrChild() == null)
				return null;
			if(node.getlChild() == null)
				return node.getrChild();
			if(node.getrChild() == null)
				return node.getlChild();
			//if two children
			TreeNode<T> successor = findSuccessor(node.getrChild());
			node.setData(successor.getData());
			System.out.println("find successor "+node.getData());
			node.setrChild(remove(node.getrChild(),successor.getData()));
			return node;
		}
		else if(node.getData().compareTo(key) > 0){
			node.setlChild(remove(node.getlChild(),key));
			return node;
		}
		else{
			node.setrChild(remove(node.getrChild(),key));
			return node;
		}
	}

	/**
	 * Validates whether the given tree is a BST
	 * @return true, if the tree is a valid BST, false otherwise
	 */
	public boolean isBST(){
		if(root==null)
			return true;
		return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	/**
	 *
	 * @param root1
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	private boolean validate(TreeNode<T> root1, Integer minValue, Integer maxValue){
		if(root1==null)
			return true;
		if( (Integer)root1.getData() <= minValue || (Integer)root1.getData() >= maxValue)
			return false;
		return validate(root1.getlChild(),minValue,(Integer)root1.getData()) &&
				validate(root1.getrChild(),(Integer)root1.getData(),maxValue);
	}

	/**
	 * In order to flatten a tree we set all left child pointers to null and right child pointers would work like next pointers for list
	 * Implementation with stack
	 */
	public void flattenTree(){
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		TreeNode<T> current = root;
		while(current != null){
			if(current.getrChild() != null)
				s.push(current.getrChild());
			if(current.getlChild() == null)
				if(!s.empty())
					current.setrChild(s.pop());
				else
					current.setrChild(null);
			else
				current.setrChild(current.getlChild());
			current.setlChild(null);
			current = current.getrChild();
		}

	}

	/**
	 * In order to flatten a tree we set all left child pointers to null and right child pointers would work like next pointers for list
	 * Implementation without using stack utility
	 */
	public void flattenTreeWithoutStack(){
		TreeNode<T> current = root;
		while(current!=null){
			if(current.getrChild() != null){
				TreeNode<T> predecessor = findPredecessor(current.getlChild());
				if(predecessor != null){
					predecessor.setrChild(current.getrChild());
				}
				else
					current.setlChild(current.getrChild());
			}
			current.setrChild(current.getlChild());
			current.setlChild(null);
			current = current.getrChild();
		}

	}

	/**
	 * Prints the boundary of the tree
	 */
	public void printBoundary(){
		//Print left
		printLeft(this.root);
		//Print leaves
		printLeaf(this.root.getlChild());
		printLeaf(this.root.getrChild());
		//Print right
		printRight(this.root);
	}

	/**
	 * Prints the left boundary of the tree rooted at node
	 * @param node
	 */
	private void printLeft(TreeNode<T> node){
		if(node == null)
			return;
		if((node.getlChild() != null) || (node.getrChild() != null)){
			System.out.print(" "+node.getData());
		}
		printLeft(node.getlChild());
	}

	/**
	 * Prints the right boundary of tree in reverse order
	 * @param node
	 */
	private void printRight(TreeNode<T> node){
		if(node==null)
			return;
		printRight(node.getrChild());
		if((node.getlChild() != null) || (node.getrChild() != null)){
			System.out.print(" "+node.getData());
		}
	}

	/**
	 * Prints the leaf nodes
	 * @param node
	 */
	private void printLeaf(TreeNode<T> node){
		if(node==null)
			return;
		printLeaf(node.getlChild());
		if((node.getlChild() == null) && (node.getrChild() == null)){
			System.out.print(" "+node.getData());
		}
		printLeaf(node.getrChild());
	}

	public void mirrorTree() {
		this.mirrorTree(root);
	}

	private TreeNode<T> mirrorTree(TreeNode<T> node) {
		if (node == null)
			return node;

		if (node.getlChild() == null && node.getrChild() == null)
			return node;

		mirrorTree(node.getlChild());
		mirrorTree(node.getrChild());

		// Swap the left and right subtrees
		TreeNode<T> temp = node.getlChild();
		node.setlChild(node.getrChild());
		node.setrChild(temp);

		return node;
	}
}