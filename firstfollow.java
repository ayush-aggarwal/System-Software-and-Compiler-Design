import java.io.*;
import java.util.*;
public class firstfollow
{	
	public static void main(String args[]) throws IOException
	{	
		int nop;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("No. of Productions:- ");//ϵƐ
		nop=Integer.parseInt(br.readLine());
		List<List> prod=new ArrayList<List>();
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
		for(int i=0;i<prod.size();i++)
			System.out.println(prod.get(i));
	}
}		
