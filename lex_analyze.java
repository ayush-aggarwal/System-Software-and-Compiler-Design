import java.io.*;
import java.util.*;
public class lex_analyze
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the String:- ");
		String input=br.readLine();
		String tokens="()+=*/-%^&";
		StringTokenizer st=new StringTokenizer(input,tokens,true);
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
	}
}
