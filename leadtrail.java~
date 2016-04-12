import java.io.*;
import java.util.*;
public class leadtrail
{
	public static List<List> prod=new ArrayList<List>();
	public static List<String> lead1=new ArrayList<String>();
	public static void lead(char a)
	{
		for(int i=0;i<prod.size();i++)
			if(prod.get(i).get(0).toString().charAt(0)==a)
				for(int j=1;j<prod.get(i).size();j++)
					if(!Character.isUpperCase(prod.get(i).get(j).toString().charAt(0)))
						lead1.add(Character.toString(prod.get(i).get(j).toString().charAt(0)));
					else if(prod.get(i).get(j).equals("ϵ"))
						lead1.add("ϵ");
					else if(Character.isUpperCase(prod.get(i).get(j).toString().charAt(0)) && prod.get(i).get(j).toString().length()>1)
					{	
						if(!Character.isUpperCase(prod.get(i).get(j).toString().charAt(1)))
							lead1.add(Character.toString(prod.get(i).get(j).toString().charAt(1)));
						else
							lead(prod.get(i).get(j).toString().charAt(0));
					}
					else
						lead(prod.get(i).get(j).toString().charAt(0));
							
	}
	public static void trail(char a)
	{
	for(int i=0;i<prod.size();i++)
			if(prod.get(i).get(0).toString().charAt(0)==a)
				for(int j=1;j<prod.get(i).size();j++)
					if(!Character.isUpperCase(prod.get(i).get(j).toString().charAt(prod.get(i).get(j).toString().length()-1)))
						lead1.add(Character.toString(prod.get(i).get(j).toString().charAt(prod.get(i).get(j).toString().length()-1)));
					else if(prod.get(i).get(j).equals("ϵ"))
						lead1.add("ϵ");
					else if(Character.isUpperCase(prod.get(i).get(j).toString().charAt(prod.get(i).get(j).toString().length()-1)) && prod.get(i).get(j).toString().length()>1)
					{	
						if(!Character.isUpperCase(prod.get(i).get(j).toString().charAt(prod.get(i).get(j).toString().length()-2)))
							lead1.add(Character.toString(prod.get(i).get(j).toString().charAt(prod.get(i).get(j).toString().length()-2)));
						else
							trail(prod.get(i).get(j).toString().charAt(prod.get(i).get(j).toString().length()-1));
					}
					else
						trail(prod.get(i).get(j).toString().charAt(prod.get(i).get(j).toString().length()-1));
	}
	public static void main(String args[]) throws IOException
	{
		int nop;
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
			lead(prod.get(i).get(0).toString().charAt(0));
			Set<String>fir=new HashSet<String>(lead1);
			System.out.println("LEADING OF "+prod.get(i).get(0).toString().charAt(0)+" is:- "+fir.toString());
			lead1.clear();
		}
		for(int i=0;i<nop;i++)
		{
			trail(prod.get(i).get(0).toString().charAt(0));
			Set<String>fir=new HashSet<String>(lead1);
			System.out.println("TRAILLING OF "+prod.get(i).get(0).toString().charAt(0)+" is:- "+fir.toString());
			lead1.clear();
		}
	}
}
