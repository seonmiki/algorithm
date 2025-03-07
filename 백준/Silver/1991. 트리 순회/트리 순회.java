import java.util.*;
import java.io.*;

public class Main {
    
    static class Node {
        char data;
        int left;
        int right;
        
        public Node(char data, int left, int right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    static class Tree {
        Node[] tree = new Node[26];  // A~Z는 총 26개

        public void preOrder(int idx) {
            if (idx == -1) return;
            System.out.print((char) ('A' + idx));
            preOrder(tree[idx].left);
            preOrder(tree[idx].right);
        }

        public void inOrder(int idx) {
            if (idx == -1) return;
            inOrder(tree[idx].left);
            System.out.print((char) ('A' + idx));
            inOrder(tree[idx].right);
        }

        public void lastOrder(int idx) {
            if (idx == -1) return;
            lastOrder(tree[idx].left);
            lastOrder(tree[idx].right);
            System.out.print((char) ('A' + idx));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            int parentIdx = parent - 'A';
            int leftIdx = (left == '.') ? -1 : (left - 'A');
            int rightIdx = (right == '.') ? -1 : (right - 'A');

            tree.tree[parentIdx] = new Node(parent, leftIdx, rightIdx);
        }

        tree.preOrder(0);
        System.out.println();
        tree.inOrder(0);
        System.out.println();
        tree.lastOrder(0);
    }
}
