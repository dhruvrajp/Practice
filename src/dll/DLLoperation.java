package dll;

public class DLLoperation {
	public static void main(String[] args)
	{
		DLL dll1=new DLL();
		DLLNode dl1=new DLLNode(7);
		DLLNode dl2=new DLLNode(8);
		DLLNode dl3=new DLLNode(9);
		DLLNode dl4=new DLLNode(10);
		DLLNode dl5=new DLLNode(11);
		DLLNode dl6=new DLLNode(12);
		DLLNode dl7=new DLLNode(13);
		dll1.insert(null,dl1,1);
		dll1.insert(dl1,dl2,2);
		dll1.insert(dl1,dl3,3);
		dll1.insert(dl1,dl4,4);
		dll1.insert(dl1,dl5,5);
		dll1.insert(dl1,dl6,6);
		dll1.insert(dl1,dl7,7);
//		System.out.println("After Delete");
//		dll1.delete(dl4, dl3, 4);
		dll1.traverse(dl1);
		dll1.dllToBST(dl1);
		
		
	}
}
