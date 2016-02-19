import java.io.*;
import java.util.*;
public class text_editor
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ch=1;
		System.out.print("Please Enter filename:- ");
		String fname=br.readLine();
		File f=new File(fname);
		if(!f.exists())
		{
			f.createNewFile();
			System.out.println("File Name:- "+fname+" created");
		}
		while(ch<=5)
		{
			System.out.println("\n\t\t\tText Editor");
			System.out.println("1. Add Data");
			System.out.println("2. Copy and Paste Data");
			System.out.println("3. Cut and Paste Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Exit");
			System.out.print("Enter Choice:- ");
			ch=Integer.parseInt(br.readLine());
			if(ch==1)
			{
				String text;
				System.out.println("Enter text:- ");
				text=br.readLine();
				FileWriter fw=new FileWriter(fname,true);
				fw.write(text);
				fw.close();
				System.out.println("Data Written in File");
			}
			if(ch==5)
				System.exit(0);
			if(ch==4)
			{
				System.out.println(fname+ " deleted !!");
				f.delete();
			}
			if(ch==2)
			{
				FileReader fr=new FileReader(fname);
				BufferedReader br1=new BufferedReader(fr);
				String data=br1.readLine();
				System.out.println(data);
				System.out.print("Enter Start Position:- ");
				int start=Integer.parseInt(br.readLine());
				System.out.print("Enter End Position:- ");
				int end=Integer.parseInt(br.readLine());
				String newdata=data.substring(start,end);
				System.out.print("Enter new file name:- ");
				String newfname=br.readLine();
				File f1=new File(newfname);
				if(!f1.exists())
				{
					f1.createNewFile();
					System.out.println("File Name:- "+newfname+" created");
				}
				FileWriter fw1=new FileWriter(newfname,true);
				fw1.write(newdata);
				fw1.close();
				System.out.println("Data Copy in File Completed!!");
			}
			if(ch==3)
			{
				FileReader fr=new FileReader(fname);
				BufferedReader br1=new BufferedReader(fr);
				String data=br1.readLine();
				System.out.println(data);
				System.out.print("Enter Start Position:- ");
				int start=Integer.parseInt(br.readLine());
				System.out.print("Enter End Position:- ");
				int end=Integer.parseInt(br.readLine());
				String newdata=data.substring(start,end);
				System.out.print("Enter new file name:- ");
				String newfname=br.readLine();
				File f1=new File(newfname);
				if(!f1.exists())
				{
					f1.createNewFile();
					System.out.println("File Name:- "+newfname+" created");
				}
				FileWriter fw1=new FileWriter(newfname,true);
				fw1.write(newdata);
				fw1.close();
				data=data.replace(newdata,"");
				FileWriter fw2=new FileWriter(fname);
				fw2.write(data);
				fw2.close();
				System.out.println("Cut-Paste Operation Completed!!");
			}
		}
	}
}
			
		
		
