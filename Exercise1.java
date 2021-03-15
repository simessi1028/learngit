import java.util.Arrays;
import java.util.List;

//求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
//input: {1,2,3,4,5}
//output:2
public class Exercise1 {
    public static void main(String [] args){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right=node3;
        node2.left = node4;
        node2.right = node5;
        System.out.print(run(root));

    }

    static public int run(TreeNode root) {
//         if(root == null)
//             return 0;
//         if(root.left==null && root.right==null)
//             return 1;
//         return 0;
        return getDeepVal(root,0);
    }
    static public int getDeepVal(TreeNode node,int depth){
        if(null ==node){
            return depth;
        }
        if(node.left==null && node.right == null){
            return depth+1;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left ==null){
            return getDeepVal(right,depth+1);
        }
        if(right ==null){
            return getDeepVal(left,depth+1);
        }
        int leftDepth = getDeepVal(left,depth+1);
        int rightDepth = getDeepVal(right,depth+1);

        if(leftDepth<rightDepth){
            return leftDepth;
        }else{
            return rightDepth;
        }
    }
}
class TreeNode{
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] array = new int[2];
        int i=0;
        int j = nums.length;
        while(i!=j){
            int val = nums[i]+nums[j-1];
            if(val ==target){
                array[0]=i;
                array[1]=j;
            }
            if(val>target){
                j--;
            }
            if(val>target){
                i++;
            }

        }
        return array;
    }
}