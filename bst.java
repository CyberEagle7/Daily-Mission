public class bst{
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node (int data){
            this.data = data;
        }
    }

    public static Node insert(int val, Node root){
        if(root == null){
            return new Node(val);
        }
        if(root.data > val){
            root.left = insert(val, root.left);
        }
        else if(root.data < val){
            root.right = insert(val, root.right);
        }
        return root;

    }

    public static void inorder (Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i = 0; i < values.length; i++){
            root = insert(values[i], root);
        }
        inorder(root);
        System.out.println();
    }
}
