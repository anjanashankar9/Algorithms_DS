import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
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

public class Tree<T extends Comparable<T>>{
	public TreeNode<T> root;
	
	public Tree(){
		root = null;
	}
	
	public void insert(T key){
		root = insert(root,key);
	}
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
	
	public void delete(Integer key){
		
	}
	
	public boolean find(Integer key){
		return find(root,key);
	}
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
	
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	public void inOrderTraversal(TreeNode<T> node){
		if(node == null)
			return;
		inOrderTraversal(node.getlChild());
		System.out.print(node.getData()+" , ");
		inOrderTraversal(node.getrChild());
	}
	
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
	
	public void preOrderTraversal(){
		preOrderTraversal(root);
	}
	public void preOrderTraversal(TreeNode<T> node){
		if(node == null)
			return;
		System.out.print(node.getData()+" , ");
		preOrderTraversal(node.getlChild());
		preOrderTraversal(node.getrChild());
	}
	
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
	
	public void postOrderTraversal(){
		postOrderTraversal(root);
	}
	public void postOrderTraversal(TreeNode<T> node){
		if(node == null)
			return;
		postOrderTraversal(node.getlChild());
		postOrderTraversal(node.getrChild());
		System.out.print(node.getData()+" , ");
	}
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
	
	public int getSize(){
		return getSize(root);
	}
	public int getSize(TreeNode<T> node){
		if(node == null)
			return 0;
		return (1+getSize(node.getlChild())+getSize(node.getrChild()));
	}
	
	public int getHeight(){
		return getHeight(root);
	}
	
	public int getHeight(TreeNode<T> node){
		if(node == null)
			return 0;
		return (1+Math.max(getHeight(node.getlChild()), getHeight(node.getrChild())));
	}
	
	public TreeNode<T> findSuccessor(TreeNode<T> node){
		//Return the smallest vaue rooted at node
		if(node == null)
			return null;
		else if(node.getlChild() == null)
			return node;
		else
			return findSuccessor(node.getlChild());
		
	}
	
	public TreeNode<T> findPredecessor(TreeNode<T> node){
		if(node == null)
			return null;
		else if(node.getrChild() == null)
			return node;
		else
			return findPredecessor(node.getrChild());
	}
	
	public void remove(T key){
		root = remove(root,key);
	}
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
	
	public boolean isBST(){
		if(root==null)
			return true;
		return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean validate(TreeNode<T> root1, Integer minValue, Integer maxValue){
		if(root1==null)
			return true;
		if( (Integer)root1.getData() <= minValue || (Integer)root1.getData() >= maxValue)
			return false;
		return validate(root1.getlChild(),minValue,(Integer)root1.getData()) &&
				validate(root1.getrChild(),(Integer)root1.getData(),maxValue);
	}
	
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
	
	public void flattenTreeWithoutStack(){
		//In order to flatten a tree we set all left child pointers to null and right child pointers would work like next pointers for list
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
	
	public void printBoundary(){
		//Print left
		printLeft(this.root);
		//Print leaves
		printLeaf(this.root.getlChild());
		printLeaf(this.root.getrChild());
		//Print right
		printRight(this.root);
	}
	
	private void printLeft(TreeNode<T> node){
		if(node == null)
			return;
		if((node.getlChild() != null) || (node.getrChild() != null)){
			System.out.print(" "+node.getData());
		}
		printLeft(node.getlChild());
	}
	
	private void printRight(TreeNode<T> node){
		if(node==null)
			return;
		printRight(node.getrChild());
		if((node.getlChild() != null) || (node.getrChild() != null)){
			System.out.print(" "+node.getData());
		}
	}
	
	private void printLeaf(TreeNode<T> node){
		if(node==null)
			return;
		printLeaf(node.getlChild());
		if((node.getlChild() == null) && (node.getrChild() == null)){
			System.out.print(" "+node.getData());
		}
		printLeaf(node.getrChild());
	}
}