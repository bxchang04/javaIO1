package tuesday.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class S18Scanner {

	public static void main(String[] args) {
		Scanner s = null;
		File readin = new File("resources/ScannerSimple.txt");
		BufferedReader bufferStream = null;
		FileReader inputStream = null;
		try {
			inputStream = new FileReader(readin);
			bufferStream = new BufferedReader(inputStream);
			s = new Scanner(bufferStream);
			
			while(s.hasNext()) {
				System.out.println(s.next());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}

	}

}
