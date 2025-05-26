import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        char name;
        Node left;
        Node right;

        Node(char name){
            this.name=name;
            this.left=null;
            this.right=null;
        }
    }

    static Node[] tree;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        tree=new Node[n+1];
       
        for(int i=1;i<=n-1; i++){
            st=new StringTokenizer(br.readLine());

            char cur = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if(tree[cur-'A']==null){
                tree[cur-'A']=new Node(cur);
            }
            if(leftChild !='.'){
                tree[leftChild-'A']=new Node(leftChild);
                tree[cur-'A'].left=tree[leftChild-'A'];
            }
            if(rightChild !='.'){
                tree[rightChild-'A']=new Node(rightChild);
                tree[cur-'A'].right=tree[rightChild-'A'];
            }
        }
        //전위순회
            sb=new StringBuilder();
            preOrder(tree[0]);
            System.out.println(sb);

            //중위
            sb=new StringBuilder();
            inOrder(tree[0]);
            System.out.println(sb);
            

            //후위
            sb=new StringBuilder();
            postOrder(tree[0]);
            System.out.println(sb);
    }

    private static void preOrder(Node node){
        if(node == null) return;
        sb.append(node.name);

        preOrder(node.left);
        preOrder(node.right);
        
    }

    private static void inOrder(Node node){
        if(node == null) return;
        
        inOrder(node.left);
        sb.append(node.name);
        inOrder(node.right);
        
    }
    private static void postOrder(Node node){
        if(node == null) return;
        
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.name);
    }
}