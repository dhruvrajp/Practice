package tree;

public class CreateTreeFromInPre {
	public static void main(String[] args){
		int[] ino={4,2,5,1,6,7,3,8};
		int[] preo={1,2,4,5,3,7,6,8};
		createTree(ino,preo);
	}
	
	static void createTree(int[] inord,int[] preord){
		int preStart=0;
		int inStart=0;
		int preEnd=preord.length-1;
		int inEnd=inord.length-1;
		createTreeRec(inord,preord,inStart,inEnd);
	}
		static int preIndex=0;
		private static BTreeNode createTreeRec(int[] inord, int[] preord, int inStart, int inEnd) {
			if(inStart>inEnd)
				return null;
			int val=preord[preIndex++];
			BTreeNode curroot=new BTreeNode(val);
			if(inStart==inEnd){
			return curroot;	
			}
			int k=0;
			for(int i=0;i<inord.length;i++){
				if(inord[i]==val){
					k=i;
					break;
				}
			}
			
			createTreeRec(inord,preord,inStart,k-1);
			createTreeRec(inord,preord,k+1,inEnd);
			
			return null;
		}
}
