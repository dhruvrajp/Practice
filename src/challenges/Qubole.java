package challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Qubole {
/*HashMap defined for each user and his/her Friend List. We use long as User id is 64 bits.
Consider this as one type of Adjacency list storing graph values. This HashMap causes O(1) time for retrieval*/	
	public static HashMap<Long,ArrayList<Long>> frndMap=new HashMap<Long,ArrayList<Long>>();
	public static void main(String[] args) throws FileNotFoundException
	{
//This takes the file input path 
		String filePath="B:/test.txt";
//This scanner will read the file
		Scanner fileReader=new Scanner(new File(filePath));
//Iterating over the file for each line		
		while(fileReader.hasNextLine())
		{
//This takes the user id on each line			
			long user=fileReader.nextInt();
//List of friends for the user
			ArrayList<Long> friends=new ArrayList<Long>();
			String line=fileReader.nextLine();
			line=line.trim();
//Splitting each line on ","			
			StringTokenizer st=new StringTokenizer(line,",");
			while(st.hasMoreTokens())
			{
				String nextT=st.nextToken();
				if(!nextT.equals(","))
				{
					friends.add(Long.parseLong(nextT));
				}
			}
//Adding the user and his/her friend list to the Adjacency List/HashMap			
			frndMap.put(user, friends);
		}
		ArrayList<Long> friendList=getFriends(12345);
		System.out.println("\n If 12345 and 56790 are Friends "+areFriends(12345,56790));
		System.out.println("\n Check If mutual friends exist "+haveMutualFriends(12345,56790));
		System.out.println("\n Mutual Friend Count " +getMutualFriendCount(12345,56790));
		ArrayList<Long> potentFriend = getPotentialFriends(12345,4);
		System.out.println("Potential Friends ");
		for(Long pFriend:potentFriend)
		{
			System.out.print(" "+pFriend);
		}
		
	}
	
/*We simply retrieve the first user from main HashMap created while parsing the file O(1)
 If first user has n friends, iterating over his friends to find second users and returning the answer
 takes O(n) time */	
	private static boolean areFriends(long i,long j) {
		ArrayList<Long> friendList;
		if(frndMap.containsKey(i))
		{
		friendList=frndMap.get(i);
		for(Long frnd:friendList)
		{
			if(frnd==j)
			{
				return true;
			}
		}
		}
		return false;
	}
	
/*Here we put the friends of first user id in a HashMap.Retrieving each user from the main HashMap(frndMap) takes O(1) time. 
We than iterate over the ArrayList of second user. While iterating we check if any friend from second user is in the HashMap for 
first User. Total time(if second user has n friends) :- O(n)+O(1) . As soon as a match is found we return true else false
*/	
	private static boolean haveMutualFriends(long i, long j) {
		HashMap<Long,Long> friendOfI = new HashMap<Long,Long>();
		if(frndMap.containsKey(i))
		{
			for(Long frnd:frndMap.get(i))
			{
				friendOfI.put(frnd, i);
			}
			if(frndMap.containsKey(j))
			{
				for(Long frnd:frndMap.get(j))
				{
					if(friendOfI.containsKey(frnd))
					{
						return true;
					}
				}
				return false;
			}
//Is users are not found in file			
			else
			{
				System.out.println(j+" Not Found");
				return false;
			}
		}
		else
		{
			System.out.println(i+" Not Found ");
			return false;
		}
		
	}

/*Same method used as above, except increment a counter if a mutual friend is found instead of returning and return the counter
 * in the end */	
	private static int getMutualFriendCount(long i, long j) {
		HashMap<Long,Long> friendOfI = new HashMap<Long,Long>();
		int count=0;
		if(frndMap.containsKey(i))
		{
			for(Long frnd:frndMap.get(i))
			{
				friendOfI.put(frnd, i);
			}
			if(frndMap.containsKey(j))
			{
				for(Long frnd:frndMap.get(j))
				{
					if(friendOfI.containsKey(frnd))
					{
//Counter for Mutual Friends						
						count++;
					}
				}
			}
			else
			{
				System.out.println(j+" Not Found");
			}
		}
		else
		{
			System.out.println(i+" Not Found ");
		}
		return count;
	}
	
	
//This method iterates over friends of the user passed and prints them. Also returns the ArrayList	
	private static ArrayList<Long> getFriends(long i) {
		ArrayList<Long> friendList;
		if(frndMap.containsKey(i))
		{
			System.out.println("Friend for user "+i);
			friendList=frndMap.get(i);
			for(Long frnd:friendList)
			{
				System.out.print(" "+frnd);
			}
			return friendList ;
		}
		else
		{
			System.out.println("Not Found");
			return null;
		}
		
		
	}
	
/*We create a List of friends for the user passed. Next we iterate over these friends as their distance is already 
 * one from the user. We now iterate over the friends of friends as there is already a mutual friend. I have marked corresponding
 * variables and loops. We add them(Friends of Friends) to a HashMap and their count. Next we sort the HashMap and return a ArrayList 
 * as per count
*/	
	private static ArrayList<Long> getPotentialFriends(long i,int j) {
		ArrayList<Long> potentialList=new ArrayList<Long>();
//Friends of the user passed		
		HashMap<Long,Long> friendListI=new HashMap<Long,Long>();
//HashMap for friends of friends and thier COunt		
		HashMap<Long,Integer> mutList=new HashMap<Long,Integer>();
		if(frndMap.containsKey(i))
		{
//Adding Friends of user passed
			for(Long friend:frndMap.get(i))
			{
				friendListI.put(friend, i);
			}
			friendListI.put(i, i);
		}		
		for(Long friend:frndMap.get(i))
		{
//This loop removes any friend in the Mutual Map that are already friends of the User passed			
			for(Long mutToMain : frndMap.get(i))
			{
				if(mutList.containsKey(mutToMain))
				{
					mutList.remove(mutToMain);
				}
			}
//Iterating over friends of Friends		
			for(Long mutFriend:frndMap.get(friend))
			{
//Increasing or putting friends as per count				
				if(mutList.containsKey(mutFriend))
				{
					int count=mutList.get(mutFriend)+1;
					mutList.put(mutFriend,count);
				}
				else
				{
					mutList.put(mutFriend,1);
				}	
			}	
		}
		
/*This portion sorts the Mutual Friend List as per the count. Returns the top 'count' elements back 
 We have created the Set, List and used new Comparator to sort the Map as per its values count.
 */
		Set<Entry<Long,Integer>> set=mutList.entrySet();
		List<Entry<Long,Integer>> sortListMutual=new ArrayList<Entry<Long,Integer>>(set);
		Collections.sort(sortListMutual,new Comparator<Map.Entry<Long,Integer>>(){

			@Override
			public int compare(Entry<Long, Integer> o1, Entry<Long, Integer> o2) {
				// TODO Auto-generated method stub
				return (o2.getValue()).compareTo(o1.getValue());
			}	
		});
		
		ArrayList<Long> retList=new ArrayList<Long>();
		int fcount=0;
		for(Map.Entry<Long, Integer> entry: sortListMutual)
		{
			if(fcount!=j)
			{
			retList.add(entry.getKey());
			fcount++;
			}
			else
			{
				break;
			}
		}
		return retList;
	}
	
}
