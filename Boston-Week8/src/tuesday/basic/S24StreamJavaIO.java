package tuesday.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class S24StreamJavaIO {

	public static void main(String[] args) {
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
			inputStream = new FileInputStream("resources/StreamSimple.txt");
			sc = new Scanner(inputStream,"UTF-8");
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
			//note that Scanner suppresses exceptions
			if(sc.ioException() !=null) {
				throw sc.ioException();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream !=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(sc!=null) {
				sc.close();
			}
		}

	}

}
