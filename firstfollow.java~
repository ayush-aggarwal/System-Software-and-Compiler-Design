import java.io.*;
import java.util.*;
public class firstfollow
{	
	public static List<List> prod=new ArrayList<List>();
	public static List<String>first1=new ArrayList<String>();
	public static void first(char a)
	{
		if(!Character.isUpperCase(a))
				first1.add(Character.toString(a));
		else
		{
			for(int i=0;i<prod.size();i++)
				if(prod.get(i).get(0).toString().charAt(0)==a)
					for(int j=1;j<prod.get(i).size();j++)
						if(!Character.isUpperCase(prod.get(i).get(j).toString().charAt(0)))
							first1.add(Character.toString(prod.get(i).get(j).toString().charAt(0)));
						else if(prod.get(i).get(j).equals("ϵ"))
							first1.add("ϵ");
						else
						{
							if(prod.get(i).get(j).toString().charAt(0)!=a)
							{
							first(prod.get(i).get(j).toString().charAt(0));
							for(int k=1;k<prod.get(i).get(j).toString().length();k++)
								if(first1.contains("ϵ"))
								{
									first1.remove("ϵ");
									first(prod.get(i).get(j).toString().charAt(k));
								}
							}
						}
		}
	}
	public static void follow(char a)
	{
		if(a==prod.get(0).get(0).toString().charAt(0))
			first1.add("$");
		for(int j=0;j<prod.size();j++)
			{
				for(int k=1;k<prod.get(j).size();k++)
					if(prod.get(j).get(k).toString().indexOf(a)!=-1)
					{
						for(int l=1;l<=prod.get(j).get(k).toString().length();l++)
						{
							int in=prod.get(j).get(k).toString().indexOf(a)+l;
							if(in<prod.get(j).get(k).toString().length())
							{
								first(prod.get(j).get(k).toString().charAt(in));
								if(first1.contains("ϵ"))
								{
									first1.remove("ϵ");
									continue;
								}
								else
									break;
							}
							else if(in>=prod.get(j).get(k).toString().length())
								if(a!=prod.get(j).get(0).toString().charAt(0))
									follow(prod.get(j).get(0).toString().charAt(0));
						}
					}
			}
		}
	public static void main(String args[]) throws IOException
	{	
		int nop,f=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("No. of Productions:- ");//ϵƐ
		nop=Integer.parseInt(br.readLine());
		System.out.println("Enter Productions");
		for(int i=0;i<nop;i++)
		{
			String in=br.readLine();
			List<String> temp=new ArrayList<String>(Arrays.asList(in.split("->")));
			List<String> temp1=new ArrayList<String>(Arrays.asList(temp.get(1).split("/")));
			temp.remove(temp.get(1));
			for(int j=0;j<temp1.size();j++)
				temp.add(temp1.get(j));
			prod.add(temp);
		}
		for(int i=0;i<nop;i++)
		{
			first(prod.get(i).get(0).toString().charAt(0));
			System.out.print("FIRST OF "+prod.get(i).get(0).toString().charAt(0)+" is:- ");
			Set<String>fir=new HashSet<String>(first1);
			System.out.println(fir.toString());
			first1.clear();
		}
		for(int i=0;i<nop;i++)
		{
			char a=prod.get(i).get(0).toString().charAt(0);
			follow(a);
			System.out.print("FOLLOW OF "+a+" is:- ");
			Set<String>fir=new HashSet<String>(first1);
			System.out.println(fir.toString());
			first1.clear();
		}
	}
}
