package challenges;

import java.io.IOException;

public class FileQ {

	public static void main(String[] args) throws IOException
	{
		String a="B:\\Test\\NewTest";
		FileList fl=new FileList(a);
		fl.printFileTree(a);
		
	}
	
	
}
