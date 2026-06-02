public class BinaryTree {
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
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = BinaryTrees.BuildTree(nodes);
    }
}
