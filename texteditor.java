import java.io.*;
import java.util.*;
public class texteditor
{
	public static void print(String str)
	{
		System.out.println(str);
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ch=1;
		String fname="";
		while(ch<8)
		{
			print("1. Create File");
			print("2. Add Date");
			print("3. Edit File");
			print("4. Cut Paste");
			print("5. Copy Paste");
			print("6. Find");
			print("7. Remove");
			print("8. Exit");
			System.out.print("Enter Your Choice: -");
			ch=Integer.parseInt(br.readLine());
			if(ch==1)
			{
				print("Filename:- ");
				fname=br.readLine();
				File f=new File(fname);
				if(!f.exists())
				{
					f.createNewFile();
					print(fname +" created");
				}
			}
			else if(ch==2)
			{
				System.out.print("Enter Text:- ");
				String text=br.readLine();
				FileWriter fw=new FileWriter(fname,true);
				fw.write(text);
				fw.close();
				print("\nSuccessfully Completed");
			}
			else if(ch==6)
			{
				System.out.print("Enter String:- ");
				String tf=br.readLine();
				FileReader fr=new FileReader(fname);
				BufferedReader bf=new BufferedReader(fr);
				String c=bf.readLine();
				if(c.indexOf(tf)!=-1)
					print(tf +" found at "+ c.indexOf(tf));
				else
					print("Data Not Found");
				bf.close();
				fr.close();
			}
			else if(ch==7)
			{
				File f=new File(fname);
				if(f.exists())
				{
					f.delete();
					print("Successfully Deleted");
				}
			}
			else if(ch==3)
			{
				System.out.print("Enter Text:-" );
				String text=br.readLine();
				FileWriter fw=new FileWriter(fname);
				fw.write(text);
				fw.close();
				print("File editted");
			}
			else if(ch==5)
			{
				System.out.print("Text in File:- ");
				FileReader fr=new FileReader(fname);
				BufferedReader bf=new BufferedReader(fr);
				String c=bf.readLine();
				print(c);
				print("Enter Start Position:- ");
				int start=Integer.parseInt(br.readLine());
				print("Enter End Position:- ");
				int end=Integer.parseInt(br.readLine());
				System.out.print("Enter new File name:- ");
				String newfname=br.readLine();
				File f1=new File(newfname);
				if(!f1.exists())
				{
					f1.createNewFile();
					print("Successfully created");
				}
				FileWriter fw=new FileWriter(newfname,true);
				fw.write(c.substring(start,end));
				fw.close();
				print("File Copy Operation Completed");
			}
			else if(ch==4)
			{
				System.out.print("Text in File:- ");
				FileReader fr=new FileReader(fname);
				BufferedReader bf=new BufferedReader(fr);
				String c=bf.readLine();
				print(c);
				print("Enter Start Position:- ");
				int start=Integer.parseInt(br.readLine());
				print("Enter End Position:- ");
				int end=Integer.parseInt(br.readLine());
				System.out.print("Enter new File name:- ");
				String newfname=br.readLine();
				File f1=new File(newfname);
				if(!f1.exists())
				{
					f1.createNewFile();
					print("Successfully created");
				}
				FileWriter fw=new FileWriter(newfname,true);
				fw.write(c.substring(start,end));
				fw.close();
				FileWriter fw1=new FileWriter(fname);
				String t=c.replace(c.substring(start,end),"");
				fw1.write(t);
				fw1.close();
				print("Cut-Paste Operation Completed");
			}
		}
	}
}
