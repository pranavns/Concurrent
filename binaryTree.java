//Binary tree implementstion in java

import java.io.*;

class binaryTree
{
	public static void main(String[] args) throws IOException
	{
		new binaryTree().run();
	}
	static class Node
	{
		int data;
		Node left = null;
		Node right= null;
		Node(int val)
		{
			this.data=val;
		}
	}
	public static Node rootnode;
	public void insert(Node node, int item)
	{
		if(node.data < item) {
			if(node.right != null)
				insert(node.right, item);
			else
				node.right = new Node(item);
		}
		else if(node.data > item) {
			if(node.left != null)
				insert(node.left, item);
			else
				node.left = new Node(item);
		}
		//else do nothing since the value is already exist
	}

	public void inorder(Node node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.print("\t"+node.data);
			inorder(node.right);
		}
	}

	public void preorder(Node node)
	{
		if(node!=null)
		{
			System.out.print("\t"+node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void postorder(Node node)
	{
		if(node!=null)
		{
			postorder(node.left);
			postorder(node.right);
			System.out.print("\t"+node.data);
		}
	}

	public Node findMin(Node node)
	{
		if(node == null)
			return null;
		else if(node.left == null)
			return node;
		return(findMin(node.left));
	}

	public Node findMax(Node node)	//return the rightmost child(maximum value)
	{
		 if(node.right == null)
			return node;
		return(findMin(node.right));
	}

	public Node delete(Node node, int item)
	{
		if(node.data < item)
			node.right=delete(node.right,item);
		else if(node.data > item)
			node.left=delete(node.left,item);
		else {
			if(node.left==null && node.right==null)	//having no childs
				node = null;
			else if(node.right == null)		//having left child only
				node=node.left;
			else if(node.left == null)		//having right child only
				node=node.right;
			else
				{node.data=findMax(node.left).data;
				node.left=delete(node.left,node.data);}
		}
		return node;	
	}

	public void search(Node node, int item)
	{
		if(node == null)
			System.out.print("The node not exist\n");
		else if(node.data == item)
			System.out.print("Node found\n");
		else if(node.data > item)
			search(node.left, item);
		else if(node.data < item)
			search(node.right, item);
		return;
	}

	public void type(Node node, int val)
	{
		if(node.data == val)
			{System.out.println("root node");}
		else if(node.right != null || node.left!= null)
			System.out.println("Intermediate node");
		else 
			System.out.println("Leaf node");
	}
	public void run() throws IOException
	{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader  buff = new BufferedReader(in);
		int opt,val;
		System.out.print("Enter the rootnode : ");
		rootnode = new Node(Integer.parseInt(buff.readLine()));
		while(true) {
			System.out.print("\nMENU\n1.Insert 2.Inorder 3.Preorder 4.Postorder 5.exit 6.minimum 7.delete 8.search 9.type\n");
			System.out.print("Choose the option: ");
			opt = Integer.parseInt(buff.readLine());
			switch(opt) {
				case 1:
					System.out.print("Enter the value to insert : ");
					val = Integer.parseInt(buff.readLine());
					insert(rootnode, val);
					break;
				case 2: inorder(rootnode);break;
				case 3: preorder(rootnode);break;
				case 4: postorder(rootnode);break;
				case 5: System.exit(0);
				case 6: System.out.println("The Minimum element is : "+findMin(rootnode).data);break;
				case 7: System.out.print("Enter the value to be deleted : ");
					if(delete(rootnode,Integer.parseInt(buff.readLine()))==null)
						System.out.println("element Not found");
					else
						System.out.println("deleted!");
					break;
				case 8:System.out.println("Enter the item to be searched!");
					search(rootnode,Integer.parseInt(buff.readLine()));break;
				case 9:System.out.println("Enter the item");
					type(rootnode,Integer.parseInt(buff.readLine()));break;
				default:System.out.print("Invalid option \n");
			}
		}
	}
}
