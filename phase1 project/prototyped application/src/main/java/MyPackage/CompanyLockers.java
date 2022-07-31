package MyPackage;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CompanyLockers {
	public static void accendingorder()

	{
		Scanner scanner = new Scanner( System.in );
		System.out.println("Enter the file path: ");
		String dirPath = scanner.nextLine(); // Takes the directory path as the user input

		File folder = new File(dirPath);
		if(folder.isDirectory())
		{
			File[] fileList = folder.listFiles();

			Arrays.sort(fileList);

			System.out.println("\nTotal number of items present in the directory: " + fileList.length );


			// Lists only files since we have applied file filter
			for(File file:fileList)
			{
				System.out.println(file.getName());
			}

			// Creating a filter to return only files.
			FileFilter fileFilter = new FileFilter()
			{
				@Override
				public boolean accept(File file) {
					return !file.isDirectory();
				}
			};

			fileList = folder.listFiles(fileFilter);

			// Sort files by name
			Arrays.sort(fileList);

			//Prints the files in file name ascending order
			for(File file:fileList)
			{
				System.out.println(file.getName());
			}

		}   
	}

	public static void displayMenu()
	{


		System.out.println("\t\t Developer Name: Employee 1\t\t");
		System.out.println("********************");
		System.out.println("\t\t1.to display all the files");
		System.out.println("\t\t2.Adding files to the existing directory");
		System.out.println("\t\t3.Deleting the file");
		System.out.println("\t\t4.Searching the file");
		System.out.println("\t\t5.Arrange in accendingorder");
		System.out.println("\t\t6.Exit");
		System.out.println("********************");
	}

	public static void getallfiles()

	{
		File[] listoffiles=new File(Projectpath).listFiles();
		if(listoffiles.length==0)
			System.out.println("No files exist in the directory");
		else
		{
			for(var l:listoffiles)
			{
				System.out.println(l.getName());
			}
		}



	}
	public static void createfile() throws IOException
	{
		try
		{
			try (Scanner obj = new Scanner(System.in)) {
				String fileName;
				int linesCount;

				System.out.println("Enter the filename");
				fileName=obj.nextLine();
				System.out.println("Enter how many line you want to add in the file");
				linesCount=Integer.parseInt(obj.nextLine());
				FileWriter fw=new FileWriter(Projectpath+"\\"+fileName);

				for(int i=1;i<=linesCount;i++)
				{
					System.out.println("Enter the content");
					fw.write(obj.nextLine()+"\n");
				}
				System.out.println("File is created successfully");
				fw.close();
			}
		}
		catch(Exception ex)
		{
			System.out.println("some error occured");
		}

	}
	public static void deletefiles()
	{
		Scanner obj=new Scanner(System.in);
		try
		{
			String fileName;
			System.out.println("Enter the filename to be deleted");
			fileName=obj.nextLine();

			File fileName1=new File(Projectpath+"\\"+fileName);
			if(fileName1.exists())
			{
				fileName1.delete();
				System.out.println("File deleted successfully");
			}
			else
			{
				System.out.println("file do not exists");	
			}}
		catch(Exception ex)
		{

			System.out.println("Exception error");
		}
	}
	public static void searchfiles()
	{
		//search Files 

		Scanner obj=new Scanner(System.in);
		try
		{
			String fileName;
			System.out.println("Enter the filename to be searched");
			fileName=obj.nextLine();

			File fileName1=new File(Projectpath+"\\"+fileName);
			if(fileName1.exists())
			{
				System.out.println("File searched successfully");
			}
			else
			{
				System.out.println("file do not exists");	
			}}
		catch(Exception ex)
		{

			System.out.println("Exception error");
		}
	}
	static final String Projectpath="C:\\Users\\91701\\simplilearn\\Assessment1";
	public static void main(String[] args) throws IOException 
	{
		Scanner Obj=new Scanner(System.in);
		int ch;
		do
		{
			displayMenu();
			System.out.println("Enter your choice");
			ch=Integer.parseInt(Obj.nextLine());
			switch(ch)
			{
			case 1:getallfiles();
			break;
			case 2:createfile();	
			break;
			case 3:deletefiles();
			break;
			case 4:searchfiles();
			break;
			case 5:accendingorder();
			break;
			case 6:System.exit(0);
			break;
			default:System.out.println("invalid option");
			break;
			}
			Obj.next();
		}
		while(ch>6);
	}
}