import java.util.*;
public class DiameterOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTrees{
        static int idx = -1;
        public static Node BuildTree(int Nodes[]){
            idx++;
            if(Nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = BuildTree(Nodes);
            newNode.right = BuildTree(Nodes);

            return newNode;
        }
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void LevelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node CurrNode = q.remove();
            if(CurrNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(CurrNode + " ");
                if(CurrNode.left != null){
                    q.add(CurrNode.left);
                }
                if(CurrNode.right != null){
                    q.add(CurrNode.right);
                }
            }
        }
    }
    public static int countnode(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countnode(root.left);
        int rightNodes = countnode(root.right);
        return leftNodes + rightNodes + 1;
    }
    public static int nodesSum(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = nodesSum(root.left);
        int rightSum = nodesSum(root.right);
        return leftSum + rightSum + root.data;
    }
    public static int NodeHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = NodeHeight(root.left);
        int rightHeight = NodeHeight(root.right);
        
        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }
    public static int DiameterOfTree(Node root){ //---------------------Here the Time Complexity is O(n^2)-------------------------
        if(root == null){
            return 0;
        }
        int leftDiameter = DiameterOfTree(root.left);
        int rightDiameter = DiameterOfTree(root.right);
        int Diameter = NodeHeight(root.left) + NodeHeight(root.right) + 1;

        return Math.max(Diameter , Math.max(rightDiameter, leftDiameter));
    }
    static int result = 0;
    public static int DiameterOfTrees(Node root){ //---------------------Here the Time Complexity is O(n)-------------------------
        if(root == null){                       //Difference hai dono me ek time km leta hai ek jyada so we prefer this one------
            return 0;
        }
        int leftDiameter = DiameterOfTrees(root.left);
        int rightDiameter = DiameterOfTrees(root.right);
        int Diameter = leftDiameter + rightDiameter;

        result = Math.max(result, Diameter);
        return Math.max(result,(Math.max(rightDiameter, leftDiameter) + 1));
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree Tree = new BinaryTree();
        Node root = BinaryTrees.BuildTree(nodes);
        // System.out.println(root.data);             //------------When we have to pritn 
        System.out.println(DiameterOfTrees(root));  
        
    }
}
