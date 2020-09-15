package tuesday.basic;

import java.io.File;

public class S21ListOfFileNames {
 
	public static void main(String[] args) {
		File file = new File("resources");
		String[] fileList = file.list();
		for(String name:fileList) {
			System.out.println(name);
		}

	}

}
