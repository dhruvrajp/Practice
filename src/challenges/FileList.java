package challenges;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileList{

	File dir;
	public FileList(String pathname){
		dir=new File(pathname);
	}

	long total=0;
	HashSet<String> pathVisited=new HashSet<String>();
	TreeMap<Long,File> bonusMap=new TreeMap<Long,File>();
	public void printFileTree(String path) throws IOException
	{
			File dir=new File(path);
			if(dir.isDirectory())
			{
				System.out.println(path+"");
				pathVisited.add(path);
				pFileTree(path);
			}
			
	}
	
	public void pFileTree(String path) throws IOException
	{
			File dir=new File(path);
			if(dir.isDirectory())
			{
				File[] sub=dir.listFiles();
				for(File f:sub)
				{
					if(pathVisited.contains(f.getCanonicalPath()))
					{
						continue;
					}
					if (f.isDirectory())
					{
						System.out.println(f.getName()+"/");
						pathVisited.add(f.getAbsolutePath());
						pFileTree(f.getPath());
					}
					else
					{	
						total=total+dir.length();
						bonusMap.put(f.length(), f);
						pathVisited.add(f.getAbsolutePath());
						System.out.println("\t"+f.getName());
					}
					
				}
				
			}
		
	}
	
		List<File[]> getFileSets(int numSets)
	{
		List<File[]> listRet=new ArrayList<File[]>();
		if(numSets<bonusMap.size()-1)
		{
		int finCount=(int) (total/numSets);
		for(Map.Entry<Long, File> me:bonusMap.entrySet())
		{
			if(me.getKey()>finCount)
			{
				File[] f1={me.getValue()};
				listRet.add(f1);
			}
			else if(me.getKey()==finCount)
			{
				File[] f2={me.getValue()};
				listRet.add(f2);
			}
			else
			{
				
			}
				
		}
		}
		else if(numSets==bonusMap.size()-1)
		{
			for(File e:bonusMap.values())
			{
				File[] f={e};
				listRet.add(f);
			}
		}
		else
		{
			System.out.println("Number of text files less than numSet");
			return null;
		}
		return listRet;
		
		
	}

}
