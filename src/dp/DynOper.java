package dp;

import java.util.*;

public class DynOper {
	public static void main(String[] args){
		String a="XAEFDS";
		String b="AYBESS";
		System.out.println(longSubSeq(a,b));
		int[] we={4,3,3,3};
		int[] val={3,2,4,1};
		int max=6;
		System.out.println(knapSack(we,val,max));
	}
	
	static int longSubSeq(String a,String b){
		LinkedHashSet<String> retSet=new LinkedHashSet<String>();
		char[] cha=a.toCharArray();
		char[] chb=b.toCharArray();
		int m=a.length();
		int n=b.length();
		int[][] table=new int[m+1][n+1];
				
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				table[i][j]=table[i+1][j+1];
				if(cha[i]==chb[j]){
					table[i][j]=table[i+1][j+1]+1;
					retSet.add(String.valueOf(cha[i]));
				}
				else{
					table[i][j]=Math.max(table[i+1][j], table[i][j+1]);
				}
			}
		}
		ArrayList<String> al=new ArrayList<String>();
		al.addAll(retSet);
		for(int i=al.size()-1;i>=0;i--){
			System.out.println(al.get(i));
		}
		return table[0][0];
	}
	
	static int editDist(String a,String b){
        char[] cha=a.toCharArray();
        char[] chb=b.toCharArray();
        int m=cha.length;
        int n=chb.length;
        int[][] tab=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            tab[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            tab[0][i]=i;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(cha[i-1]==chb[j-1]){
                    tab[i][j]=tab[i-1][j-1];
                }else{
                    int ins=tab[i-1][j]+1;
                    int del=tab[i][j-1]+1;
                    int rep=tab[i-1][j-1]+1;
                    int min=Math.min(ins,del);
                    if(min>rep){
                        tab[i][j]=tab[i-1][j-1]+1;
                    }else{
                        tab[i][j]=min;
                    }
                }
            }
        }
        return tab[m][n];
    }
	
	
	static int knapSack(int[] we,int[] val,int max){
		int[][] dptab=new int[we.length+1][max+1];
		for(int i=0;i<=we.length;i++){
			for(int j=0;j<=max;j++){
				if(i==0||j==0){
					dptab[i][j]=0;
				}
				else if(we[i-1]<=j){
					dptab[i][j]=Math.max(dptab[i-1][j],val[i-1]+dptab[i-1][j-we[i-1]]);
				}else{
					dptab[i][j]=dptab[i-1][j];
				}
			}
		}
		return dptab[we.length][max];
		}
}
