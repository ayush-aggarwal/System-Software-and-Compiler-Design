import java.io.*;
import java.util.*;
public class nfatodfa
{
	public static int states,inputs;
	public static void display(String arr[][],int ctr,Set<String> mainset)
	{
		List<String> list = new ArrayList<String>(mainset);
		for(int i=0;i<states;i++)
			list.add(i,"{"+(char)(i+112)+"}");
		String[] str=list.toArray(new String[list.size()]);
		for(int i=0;i<inputs;i++)
			System.out.print("\t"+i);
		System.out.println();
		for(int i=0;i<ctr;i++)
		{
			System.out.print(str[i]+"\t");
			for(int j=0;j<inputs;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int l,p,q,ctr=0;
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
		for(ctr=0;ctr<states;ctr++)
		{
			for(int j=0;j<inputs;j++)
			{
				System.out.print("State "+(char)(ctr+112)+" Input "+(j)+" :- ");
				arr[ctr][j]=br.readLine();
			}
		}
		for(int i=0;i<states;i++)		//develop power set
			a=a+"0";
		for(int j=0;j<states-1;j++)
			b=b+"0";
		b=b+"1";
		set.add("{0}");
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
					c=c+","+(char)(x+112);
			if(c.length()!=2)								// removing states already present in transition table
				set.add("{"+c.substring(1,c.length())+"}");
			c="";
		}
		Iterator iter=set.iterator();
		while(iter.hasNext())
		{
			String temp=iter.next().toString().replace("{","").replace("}","").replace(",","");
			if(temp.equals("0"))
			{
				arr[ctr][0]="{0}";
				arr[ctr][1]="{0}";
				ctr=ctr+1;	
			}
			else
			{
				char temparr[]=temp.toCharArray();
				for(int o=0;o<inputs;o++)
				{
					SortedSet<String> tempset = new TreeSet<String>(Arrays.asList(arr[(int)temparr[0]-112][o].replace("{","").replace("}","").split(",")));
					for(int m=0;m<temparr.length;m++)
						tempset.addAll(Arrays.asList(arr[(int)temparr[m]-112][o].replace("{","").replace("}","").split(",")));
					if(tempset.contains("0"))
						tempset.remove("0");
					arr[ctr][o]=tempset.toString().replace("[","{").replace("]","}").replace(" ","");
				}
				ctr=ctr+1;
			}
		}
		display(arr,ctr,set);
	}
}		
			
