import java.io.*;
import java.util.*;
public class firstfollow
{	
	public static List<List> prod=new ArrayList<List>();
	public static List<String>first1=new ArrayList<String>();
	public static void first(char a)
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
						first(prod.get(i).get(j).toString().charAt(0));
						for(int k=1;k<prod.get(i).get(j).toString().length();k++)
							if(first1.contains("ϵ"))
							{
								first1.remove("ϵ");
								first(prod.get(i).get(j).toString().charAt(k));
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
	}
}
