import java.util.Random;
/*
 * Author: Pamidi S
 * Description: This java file contains the methods to insert and find elements into and
 * from the binary Search tree
 * Date Creatd: 10/14/2015 
 * 
 * 
 */
public class BinarySearchTree {

	public Node root;

	public BinarySearchTree() {

		this.root = null;

	}

	/* insert integers to binary tree */

	public void insert(int value) {

		Node node = new Node(value);

		if (root == null) {

			root = node;

			return;

		}
		try{
		insertRec(root, node);
		}
		
		catch(Exception e){
			
			System.out.println("Exception in the catch block"+e.getStackTrace());
		}

	}

	private void insertRec(Node latestRoot, Node node) {

		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {

				latestRoot.left = node;

				return;

			}

			else {

				insertRec(latestRoot.left, node);

			}

		}

		else {
			if (latestRoot.right == null) {

				latestRoot.right = node;

				return;

			}

			else

				insertRec(latestRoot.right, node);

		}

	}
	
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	
	public void insert_find_no(int n){
		
		try{
		Random rndm = new Random();
		BinarySearchTree tree= new BinarySearchTree();
		int min = 1;
		int max = 10000000;
		int i=0;
		int trials = 100;// Run each Experiment 100 times
		long insertiontotalTime=0;
		long insertionStartTime = System.currentTimeMillis();
		while (trials > 0)
		{
		//startTime = System.currentTimeMillis();
		while (i < n)
		{
			tree.insert(rndm.nextInt(max - min + 1));
			i++;
			
		}
		
		trials--;
		}
		long insertionEndTime   = System.currentTimeMillis();
		//System.out.println("starttime"+insertionStartTime+"End time"+insertionEndTime);
		insertiontotalTime = insertionEndTime - insertionStartTime;
		//System.out.println("Time before Aerage"+insertiontotalTime+" ms");
		insertiontotalTime /= 100;
		//System.out.println("n="+n+" : insert: "+ totalTime+" ms; find:"+ "xxx.xxx ms");
		
		 i=0;
		 trials = 100;// Run each Experiment 100 times
		 long findtotalTime=0;
		 long findStartTime = System.currentTimeMillis();
		while (trials > 0)
		{
		//startTime = System.currentTimeMillis();
		while (i < n)
		{
			tree.find(rndm.nextInt(max - min + 1));
			i++;
			
		}
		
		trials--;
		}
		long findEndTime   = System.currentTimeMillis();
		//System.out.println("starttime"+findStartTime+"End time"+findEndTime);
		findtotalTime = findEndTime - findStartTime;
		
		findtotalTime /= 100;
		System.out.println("n="+n+" : Insert: "+ insertiontotalTime+" ms; find:"+ findtotalTime+" ms");
	}
	
	catch(Exception e){
		System.out.println("Exception in methode"+e.getStackTrace());
	}

}
	
}
