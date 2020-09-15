package tuesday.basic;

import java.io.File;
import java.io.IOException;

public class S25DeleteFileOnExit {

	public static void main(String[] args) {
		File temp;
		try {
			temp = File.createTempFile("myTempFile", ".txt", new File("resources"));
			System.out.println("Temp file created: "+ temp.getPath());
			//temp.delete(); // for deleting immediately
			System.out.println("Temp file exists: "+temp.exists());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
