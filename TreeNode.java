import java.util.List;

class Pair<T,V>{
	T first;
	V second;
	
	public Pair(T first,V second) {
		this.first=first;
		this.second=second;
	}
	
};
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val){
		this.val=val;
		this.left=null;
		this.right=null;
	}
	
}
