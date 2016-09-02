import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TreeNode {

	public int start;
	public int end;
	public int size;

	public TreeNode(int start, int end, int size) {
		this.start = start;
		this.end = end;
		this.size = size;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int junction = sc.nextInt();
		int queues = sc.nextInt();
		int[][] values = new int[queues][queues];
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		for (int i = 1; i <= queues; i++) {
			TreeNode treeNode = new TreeNode(sc.nextInt(), sc.nextInt(), sc.nextInt());
			treeNodes.add(treeNode);
		}
		calculateShortedtPath(treeNodes, queues, junction);
		sc.close();
	}

	private static void calculateShortedtPath(List<TreeNode> values, int queues,
			int junction) {
		int temparr [][] = new int[queues][queues];
		for(TreeNode treeNode : values){
			temparr[treeNode.start][treeNode.end] = treeNode.size;
		}
		int arr[] = new int[junction];
		List<Integer> list = new ArrayList<Integer>();
		list.add(values.get(0).end);
		Iterator<TreeNode> iterator = values.iterator();
		int i = 0;
		int j = 1;
		while(iterator.hasNext()){
			TreeNode treeNode = iterator.next();
			if(treeNode.end == list.get(i)){
				arr[++i] = treeNode.start;
				iterator.remove();
			} else if(!list.contains(treeNode.end)){
				list.add(treeNode.end,j++);
			}
			
		}
	}
	
	/*private TreeNode createTreeNode(Integer[] input, int index){
	    if(index<=input.length){
	        Integer value = input[index-1];
	        if(value!=null){
	            TreeNode t = new TreeNode(value);
	            t.left = createTreeNode(input, index*2);
	            t.right = createTreeNode(input, index*2+1);
	            return t;
	        }
	    }
	    return null;
	}*/
}
