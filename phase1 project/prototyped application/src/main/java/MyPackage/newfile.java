package MyPackage;
import java.io.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
public class newfile {

	private static void CreateFileUsingFileClass() throws IOException{
		File file=new File("C:\\Users\\91701\\simplilearn\\createfile.txt");
		if(file.createNewFile()) {
			System.out.println("file is created");
		}
		else {
			System.out.println("file is already created");
		}
		FileWriter writer=new FileWriter(file);
		writer.write("created the file using java program");
		writer.close();
	}
	private static void CreateFileUsingOutputStreamClass() throws IOException{
		String data="need to do the assignment";
		FileOutputStream out=new FileOutputStream("C:\\Users\\91701\\simplilearn\\Assessment1");
				out.write(data.getBytes());
				out.close();
		}
	private static void CreateFileIn_NIO() throws IOException{
		String data ="company files";
		Files.write(Paths.get("C:\\Users\\91701\\simplilearn\\Assessment1"),data.getBytes());
		List<String> lines=Arrays.asList("1st line,2nd line");
		Files.write(Paths.get("day06.txt"),lines,StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
CreateFileUsingFileClass();
CreateFileUsingOutputStreamClass();
	CreateFileIn_NIO();
	}

}
