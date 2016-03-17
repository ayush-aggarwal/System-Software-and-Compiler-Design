import java.io.*;
import java.util.*;
public class nfatodfa
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int states,inputs,l,p,q;
		String start,end,a="",b="",t,c="";
		Set<String> set = new HashSet<String>();
		System.out.print("Number of states:- ");
		states=Integer.parseInt(br.readLine());
		System.out.print("Number of inputs:- ");
		inputs=Integer.parseInt(br.readLine());
		System.out.print("Start State:- ");
		start=br.readLine();
		System.out.print("End State:- ");
		end=br.readLine();
		String arr[][]=new String[(int)Math.pow(2,states)][inputs];
		for(int i=0;i<states;i++)
			for(int j=0;j<inputs;j++)
			{
				System.out.print("State "+(char)(i+80)+" Input "+(j)+" :- ");
				arr[i][j]=br.readLine();
			}
		for(int i=0;i<states;i++)		//develop power set
			a=a+"0";
		for(int j=0;j<states-1;j++)
			b=b+"0";
		b=b+"1";
		set.add("{}");
		p=Integer.parseInt(a,2);
		q=Integer.parseInt(b,2);
		for(int z=0;z<=Math.pow(2,states)-2;z++)
		{
			p=p+q;
			t=Integer.toBinaryString(p);
			l=states-t.length();
			for(int y=0;y<l;y++)
				t="0"+t;
			for(int x=0;x<t.length();x++)
				if (t.charAt(x)=='1')
					c=c+","+(char)(x+80);
			if(c.length()!=2)								// removing states already present in transition table
				set.add("{"+c.substring(1,c.length())+"}");
			c="";
		}
		System.out.println("Power Set:- "+set);
	}
}		
			
