import java.io.*;
import java.util.*;
public class predictparse
{
	public static List<List> prod=new ArrayList<List>();
	public static List<String>first1=new ArrayList<String>();
	public static List<List> fi=new ArrayList<List>();
	public static List<List> fo=new ArrayList<List>();
	public static List<String> nt=new ArrayList<String>();
	public static List<String> ter=new ArrayList<String>();
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
	public static void getnt()
	{
		for(int i=0;i<prod.size();i++)
			nt.add(prod.get(i).get(0).toString());
	}
	public static void getter()
	{
		List<String> ter1=new ArrayList<String>();
		List<String> ter2=new ArrayList<String>();
		for(int i=0;i<prod.size();i++)
		{
			for(int j=1;j<prod.get(i).size();j++)
			{
				for(int k=0;k<prod.get(i).get(j).toString().length();k++)
				{
					if(Character.isLowerCase(prod.get(i).get(j).toString().charAt(k)))
						ter1.add(Character.toString(prod.get(i).get(j).toString().charAt(k)));
				}
			}
		}
		Set<String> temp=new HashSet<String>(ter1);
		ter2=new ArrayList<String>(Arrays.asList(temp.toString().replace("[","").replace("]","").split(",")));
		ter2.add("$");
		for(int i=0;i<ter2.size();i++)
			if(!ter2.get(i).contains("ϵ"))
				ter.add(ter2.get(i));
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
		getnt();
		getter();
		for(int i=0;i<nop;i++)
		{
			first(prod.get(i).get(0).toString().charAt(0));
			Set<String>fir=new HashSet<String>(first1);
			List<String> t=new ArrayList<String>(Arrays.asList(fir.toString().replace("[","").replace("]","").split(",")));
			t.add(prod.get(i).get(0).toString());
			fi.add(t);
			first1.clear();
		}
		for(int i=0;i<nop;i++)
		{
			char a=prod.get(i).get(0).toString().charAt(0);
			follow(a);
			Set<String>fir=new HashSet<String>(first1);
			List<String> t=new ArrayList<String>(Arrays.asList(fir.toString().replace("[","").replace("]","").split(",")));
			t.add(prod.get(i).get(0).toString());
			fo.add(t);
			first1.clear();
		}
		System.out.println(fi);
		System.out.println(fo);
		System.out.println(nt);
		System.out.println(ter);
		String parsetable[]=new String[nt.size()][ter.size()];
		
	}
}
