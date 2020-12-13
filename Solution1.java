import java.util.*;

class Point implements Comparator{
    int x,y;
    
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

	
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
}
public class Solution1 {
	
	public static int SelectPairs(List<Integer> numbers) {

		PriorityQueue<Integer> queue=new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0;i<numbers.size();i++) {
			queue.add(numbers.get(i));
		}
		
		while(queue.size()>=2) {
			int first=queue.poll();
			int second=queue.poll();
			int diff=Math.abs(first-second);
			if(diff!=0) {
				queue.add(diff);
			}
		}
		
		if(queue.size()==0) {
			return 0;
		}
		return queue.peek();
    }
	
	public static int question2(String v1,String v2) {
		int version_1=0,version_2=0;
        int i=0,j=0;
        int flag=0;
        while(i<v1.length()&&j<v2.length()){
            
            while(i<v1.length()&&v1.charAt(i)!='.'){
                int x=v1.charAt(i)-'0';
                version_1=version_1*10+x;
                i++;
            }
            
            while(j<v2.length()&&v2.charAt(j)!='.'){
                int y=v2.charAt(j)-'0';
                version_2=version_2*10+y;
                j++;
            }                
            
            if(version_1>version_2){
                return 1;
            }else if(version_1<version_2){
                return -1;
            }else{
               //  We have to check now more : so keep flag as 0 
                flag=0;
            }
            
        }
       if(i<v1.length()){
           return 1;
       }
       if(j<v2.length()){
           return -1;
       }
       return flag;
	}
	
	public static void main(String[] args) {
		
		String v1="ab";
		String v2="ac";
	
		int i=0,j=0;
		while(i<v1.length()&&j<v2.length()) {
			System.out.println(v1.charAt(i)<v2.charAt(j));
			i++;
			j++;
			
		}
		
	}
}
