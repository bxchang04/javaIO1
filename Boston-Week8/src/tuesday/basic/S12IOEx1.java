package tuesday.basic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class S12IOEx1 {

	public static void main(String[] args) throws IOException {
		
		FileReader inputStream = null;
		FileWriter outputStream = null;
		
		File readin = new File("resources/sample.txt");
		//using method to print path
		printPaths(readin);
		File writeTo = new File("resources/sampleTo.txt");
		
		//check if file exists, preventing java creating a new file
		boolean exists = writeTo.exists();
	
		//using method to print path
		printPaths(writeTo);
		
		 
		try {
			// test
			if(exists) {
			inputStream = new FileReader(readin);
			// write sample.txt to sampleTo.txt, append to sampleTo.txt and don't overwrite file
			
			outputStream = new FileWriter(writeTo,true);
			int c;
			// while sample.txt is not empty char read the file
			while((c = inputStream.read()) !=-1) {
				outputStream.write(c);
			}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream!=null)
				inputStream.close();
			if(outputStream!=null) {
				outputStream.close();
				
				System.out.println("\n" + writeTo.getPath() + " Saved!");
			} else {
				System.out.println("Error saving to "+writeTo.getPath());
			}
		}

	}
	// method to print out the File Absolute Path, Canonical Path, and Path.
	public static void printPaths(File file) throws IOException {
		System.out.println("Absolute Path: " + file.getAbsolutePath());
		System.out.println("Canonical Path: " + file.getCanonicalPath());
		System.out.println("Path: " + file.getPath());
	}

}
