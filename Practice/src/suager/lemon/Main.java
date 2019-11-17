package suager.lemon;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    }
}
//非递归中序遍历二叉树
class TreeNode {
     int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!= null || ! stack.isEmpty() ){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
//颜色分类
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0,cur = 0,p2 = len - 1;
        int temp;
        while(cur <= p2){
            if(nums[cur] == 0){
                temp = nums[p0];
                nums[p0 ++] = nums[cur];
                nums[cur ++] = temp;
            }else if(nums[cur] == 2){
                temp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2 --] = temp;
            }else
                cur ++;
        }
    }
}
//1249.移除无效的括号
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c >= 'a'){
                builder.append(c);
            }
            if(c == ')'){
                if(stack.isEmpty()){
                    continue;
                }else {
                    stack.pop();
                    builder.append(c);
                }
            }else if(c == '('){
                stack.push(c);
                builder.append(c);
            }
        }
        for(int i = 0; i < stack.size(); i ++){

            builder.deleteCharAt(builder.lastIndexOf("("));
        }
        return builder.toString();
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}
//分隔链表
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode node = new ListNode(0);
        ListNode before = node;
        ListNode node1 = new ListNode(0);
        ListNode after = node1;
        while(head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = node1.next;
        return node.next;
    }
}
//最接近的三数之和
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2 ; i ++){
            int L = i + 1;
            int R = len - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(Math.abs(target - sum) < Math.abs(target - res))
                    res = sum;
                if(sum > target)
                    R --;
                else if (sum < target){
                    L ++;
                }else{
                    return res;
                }

            }
        }
        return res;
    }
}

