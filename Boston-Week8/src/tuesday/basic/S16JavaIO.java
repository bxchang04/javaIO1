package tuesday.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
/*
 * Resource about Java IO: Readers and Writers
 * http://tutorials.jenkov.com/java-io/readers-writers.html#:~:text=The%20Java%20Reader%20is%20the,InputStreamReader%20%2C%20StringReader%20and%20several%20others.
 */
public class S16JavaIO {

	public static void main(String[] args) throws IOException {
		// File reader for input and File Writer for output
		FileReader inputStream = null;
		FileWriter outputStream = null;
		BufferedReader bufferStream = null;
		PrintWriter printStream = null;
		// file to read from
		File readin = new File("resources/JavaIOsample.txt");
		// print path
		S12IOEx1.printPaths(readin);
		// file to write to
		File writeTo = new File("resources/JavaIOsampleTo.txt");
		// check if file exists, preventing java creating a new file
		boolean exists = writeTo.exists();
		// print path
		S12IOEx1.printPaths(writeTo);
		// different way of Combining Readers and Writers
		// Reader reader = new BufferedReader(new FileReader(readin));
		// Writer writer = new BufferedWriter(new FileWriter(writeTo));
		try {
			// check if the file to write to exist or not
			if (exists) {

				inputStream = new FileReader(readin);
				outputStream = new FileWriter(writeTo, true);

				bufferStream = new BufferedReader(inputStream);
				printStream = new PrintWriter(outputStream);

				String l;

				while ((l = bufferStream.readLine()) != null) {
					printStream.println(l);
				}

			} else {
				System.out.println(writeTo.getPath() + "Don't Exist!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // this block is important 
			try {
				if (inputStream != null)
					inputStream.close();
				//check if outputStream was closed (saved)
				if (outputStream != null) {
					outputStream.close();
					System.out.println("\n" + writeTo.getPath() + " Saved!");
				} else {
					System.out.println("Error saving to " + writeTo.getPath());
				}
				if (bufferStream != null)
					bufferStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // inner catch ends

			if (printStream != null)
				printStream.close();
		} // finally ends

	} // main

}// class
