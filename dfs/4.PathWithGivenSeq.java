

/**

Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.


Time: O(n)
Space: O(n) 

Time complexity#

The time complexity of the above algorithm is O(N)O(N)O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

Space complexity#

The space complexity of the above algorithm will be O(N)O(N)O(N) in the worst case. This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child).


**/


import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {

    return findPathHelper(root, sequence, 0); 
  }

  public static boolean findPathHelper(TreeNode root, int[] arr, int idx){
    if(root == null || idx == arr.length){
      return false; 
    }

    if(root.val != arr[idx]){
      return false;
    } else if(root.left == null && root.right == null && idx == arr.length - 1){
      return true; 
    }
      return findPathHelper(root.left, arr, idx+1) || findPathHelper(root.right, arr, idx+1); 
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}
