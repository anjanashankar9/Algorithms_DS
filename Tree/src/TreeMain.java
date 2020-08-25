import java.util.List;

/**
 * Main function to test tree
 */
public class TreeMain {

	public static void main(String[] args){
		Tree<Integer> tree = new Tree<Integer>();
		tree.insert(7);
		tree.insert(4);
		tree.insert(10);
		tree.insert(2);
		tree.insert(6);
		tree.insert(9);
		//tree.insert(8);
		tree.insert(3);
		tree.insert(1);
		tree.insert(5);

		tree.inOrderTraversal();
		System.out.println();

//		tree.mirrorTree();
//		tree.inOrderTraversal();

        System.out.println(tree.findLCA(1, 3).getData());
        System.out.println(tree.findLCA(1, 2).getData());
        System.out.println(tree.findLCA(4, 10).getData());
        System.out.println(tree.findLCA(4, 5).getData());
		System.out.println();
		/*tree.inOrderTraversalIter();
		System.out.println();
		tree.preOrderTraversal();
		System.out.println();
		tree.preOrderTraversalIter();
		System.out.println();
		tree.postOrderTraversal();
		System.out.println();
		tree.postOrderTraversalIter();
		System.out.println();
		tree.levelOrderTraversal();
		System.out.println();
		int size = tree.getSize();
		System.out.println("Size : "+size);
		int height = tree.getHeight();
		System.out.println("Height : "+height);*/
		
		/*tree.remove(7);
		
		tree.inOrderTraversal();
		System.out.println();
		tree.preOrderTraversal();
		System.out.println();
		tree.postOrderTraversal();
		System.out.println();*/
		
		//System.out.println("isBST : "+tree.isBST());
		
		/*//tree.flattenTree();
		tree.flattenTreeWithoutStack();
		System.out.println(" --- ");
		tree.inOrderTraversal();*/
		
		System.out.println("---------------");
		tree.printBoundary();
		
	}
}
