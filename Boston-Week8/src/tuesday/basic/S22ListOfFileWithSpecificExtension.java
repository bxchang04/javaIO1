package tuesday.basic;

import java.io.File;

public class S22ListOfFileWithSpecificExtension {
 // search for test.pdf !!
	public static void main(String[] args) {
		File file = new File("resources");
		String[] list= file.list();
		for(String f:list) {
			if(f.toLowerCase().endsWith(".txt")) {
				System.out.println(f);
			}
		}

	}

}
