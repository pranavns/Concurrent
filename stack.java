//Stack implementation
import java.io.*;
class stac
{
	final int maxSize;
	int top, nItems;
	int arr[];
	stac(int s)
	{
		maxSize = s;
		arr = new int[maxSize];
		top =0;
		nItems = 0;
	}
	public void push(int item)
	{
		if(top == maxSize)
			{System.out.println("Stack overflow");
			return;}
		arr[top++]=item;
	}
	public int pop()
	{
		if(top == 0)
			{System.out.println("Stack overflow");
			return(-99);}
		int num = arr[top];
		top--;
		return(num);
	}
	public boolean isEmpty()
	{
		return(top == 0);
	}
	public boolean isFull()
	{
		return(top == maxSize);
	}
	public void prints()
	{
		for(int i=0;i<=top;i++)
			System.out.print(arr[i]+" ");
	}
}

class stack
{
	public static void main(String args[]) throws IOException
	{
		InputStreamReader inps= new InputStreamReader(System.in);
		BufferedReader buff= new BufferedReader(inps);
		int opt;
		stac s = new stac(5);
		while(true) {
			System.out.println("MENU 1.push 2.pop 3.isempty 4.isfull 5.printstack 6.exit");
			System.out.print("Enter the option : ");
			opt = Integer.parseInt(buff.readLine());
			switch(opt) {
				case 1:System.out.println("Enter the number : ");
					s.push(Integer.parseInt(buff.readLine()));
					break;
				case 2:System.out.println("deleted number : "+s.pop());break;
				case 3:if(s.isEmpty())
						System.out.println("Empty ");
					else
						System.out.println("Not empty ");
					break;
				case 4:if(s.isFull())
						System.out.println("Full ");
					else
						System.out.println("Not full ");
					break;
				case 5:System.out.println("Stack is");s.prints();break;
				case 6:System.exit(0);
			}
		}
	}
}
