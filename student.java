import java.io.*;
import java.util.*;
public class student implements Serializable
	{
		String regno;
		String Name;
		String Branch;
		String City;
		public String input() throws IOException
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please Enter the regno:- ");
			this.regno=br.readLine();
			System.out.print("Please Enter Name :- ");
			this.Name=br.readLine();
			System.out.print("Please Enter Branch:- ");
			this.Branch=br.readLine();
			System.out.print("Please Enter City:- ");
			this.City=br.readLine();
			return this.regno;
		}
		public void display()
		{
			System.out.println("\nRecord Entered :- \n");
			System.out.println("Register Number:- "+this.regno);
			System.out.println("Name:- "+this.Name);
			System.out.println("Branch:- "+this.Branch);
			System.out.println("City:- "+this.City);
		}
		public void modify() throws IOException
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Register Number:- "+this.regno);
			System.out.print("Please Enter Name :- ");
			this.Name=br.readLine();
			System.out.print("Please Enter Branch:- ");
			this.Branch=br.readLine();
			System.out.print("Please Enter City:- ");
			this.City=br.readLine();
		}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ch=1;
		try
		{
			while(ch<=5)
			{
				System.out.println("\n\n\t\tFile Management Menu");
				System.out.println("1. Add Data Record ");
				System.out.println("2. Delete File ");
				System.out.println("3. Display Record:- ");
				System.out.println("4. Modify Data ");
				System.out.println("5. Exit ");
				System.out.print("Please Enter Your Choice:- ");
				ch=Integer.parseInt(br.readLine());			
				if(ch==1)
				{
					student s=new student();
					String r=s.input();
					String fname=(String)r+".txt";
					File f=new File(fname);
					if(!f.exists())
					{
						f.createNewFile();
						System.out.println("File Name:- "+fname+" created");
					}
					else
					{
						System.out.println("File Already Exists!!");
						continue;
					}
					FileOutputStream fout=new FileOutputStream(fname);
					ObjectOutputStream oos=new ObjectOutputStream(fout);
					oos.writeObject(s);
					oos.flush();
					oos.close();
					fout.close();
					System.out.println("\nRecord Written in File ");
				}
				if(ch==3)
				{
					System.out.print("Please Enter the register number:- ");
					String r=br.readLine();
					String fname=r+".txt";
					ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fname));
					student o=(student)ois.readObject();
					ois.close();
					o.display();
				}
				if(ch==2)
				{
					System.out.print("Please Enter the register number:- ");
					String r=br.readLine();
					String fname=r+".txt";
					File f=new File(fname);
					f.delete();
					System.out.println("File "+fname+" deleted !!"); 
				}
				if(ch==4)
				{
					System.out.print("Please Enter the register number:- ");
					String r=br.readLine();
					String fname=r+".txt";
					ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fname));
					student o=(student)ois.readObject();
					ois.close();
					o.modify();
					FileOutputStream fout=new FileOutputStream(fname);
					ObjectOutputStream oos=new ObjectOutputStream(fout);
					oos.writeObject(o);
					oos.flush();
					oos.close();
					fout.close();
					System.out.println("\nRecord Modified");
				}	
				if(ch==5)
				{
					System.exit(0);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}
