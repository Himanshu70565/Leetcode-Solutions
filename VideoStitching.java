import java.util.*;

class Clips implements Comparator<Clips>{
	int start,end;
	
	public Clips() {}
	
	public Clips(int s,int e) {
		this.start=s;
		this.end=e;
	}

	@Override
	public int compare(Clips o1, Clips o2) {
		if(o1.start>o2.start) {
			return 1;
		}else if(o1.start<o2.start) {
			return -1;
		}else {
			if(o1.end>o2.end) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}

public class VideoStitching {
	
//	Wrong Answer 50/52 Test case passed
	public static int solve(int clips[][],int n,int T) {
		
		Clips array[]=new Clips[n];
		
		for(int i=0;i<n;i++) {
			array[i]=new Clips(clips[i][0],clips[i][1]);
		}
		
		Arrays.sort(array,new Clips());
		
		ArrayList<Clips> list=new ArrayList<Clips>();
		list.add(array[0]);
		
		for(int i=1;i<n;i++) {
			
			int len=list.size();
			Clips previous=list.get(len-1);
			
			Clips current=array[i];
			
			if(previous.end>=T) {
				break;
			}
			
//			Skip int this case :
			if(current.start>=previous.start&&current.end<=previous.end) {
				continue;
			}
//			Completely outside : 
			if(current.start>previous.end) {
				list.add(current);
			}
//			Partial :
			if(current.start<=previous.end) {
				
				while(!list.isEmpty()) {
					
					int size=list.size();
					previous=list.get(size-1);
					
					if(current.start<=previous.start&&previous.end<=current.end) {
						list.remove(size-1);
					}	
					else {
						break;
					}
				}
				list.add(current);
			}
		}
		if(list.get(list.size()-1).end<T||list.get(0).start!=0) {
			return -1;
		}
		
		int ans=list.size();
		int count=0;
		
		ArrayList<Clips> finalList=new ArrayList<Clips>();
		
		for(int i=list.size()-1;i>=0;) {
			Clips current=list.get(i);
			finalList.add(current);
			count++;
			for(int j=i-1;j>=0;j--) {
				Clips previous=list.get(j);
				if(previous.end==current.start) {
					i=j+1;
					break;
				}
			}
		i--;
		}
		
		
		for(int i=finalList.size()-1;i>0;i--) {
			Clips current =finalList.get(i);
			Clips previous=finalList.get(i-1);
			if(previous.start>current.end) {
				return -1;
			}
		}
		
		for(int i=0;i<finalList.size();i++) {
			Clips current =finalList.get(i);
			System.out.println(current.start+" "+current.end);
		}
		
		
		return finalList.size();
	}
	
	public static void main(String[] args) {
		
		int array[][]={{24,28},{10,56},{50,78},{38,77},{38,78},{3,69},{33,49},{66,89},{73,83},{6,12},{24,86},{67,82},{18,26},{1,57},{13,30},{8,56},{58,78},{2,84},{35,39},{45,51},{30,32},{19,31},{32,70},{1,15},{16,18},{32,87},{32,87},{39,42},{81,84},{25,61},{26,34},{10,82},{17,34},{56,72},{17,22},{8,83},{5,21},{3,79},{12,73},{0,28},{74,76},{41,79},{4,60},{51,90},{10,41},{47,90},{44,56},{13,16},{43,83},{0,22},{30,40},{8,27},{57,58},{0,26},{16,66},{62,89},{2,74},{17,61},{25,28},{23,54},{42,79},{14,28},{26,77},{34,36},{17,42},{72,81},{12,87},{3,57},{81,88},{65,87},{35,74},{19,77},{10,53},{38,75},{14,90},{10,90},{57,62},{37,74},{24,80},{52,63},{52,55},{64,73},{45,79},{12,19},{26,38},{40,81},{28,48},{33,62},{18,50},{9,40}};
		System.out.println(solve(array, array.length, 72));
		
	}
}
