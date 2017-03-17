import java.util.Arrays;
import java.util.Hashtable;

public class syx {

	public static void main(String[] args) {
		
		//int[] b = new int[3]; 
		//int[] a = {4,5,5,5,4,3,5,2,7,7,7,7,7,7,7};
		//System.out.println(maxSubsequence(a));
		int[] b = {1,2,3,4,5,6,7,7};
		System.out.println(""+3);

	}

	public static int maxSubsequence(int[] a){
		   Arrays.sort(a);
	       int last=-1;
	       int current=0;
	       int max_len=0;
	       int i=0;
	       for(;i<a.length;i++){
	           if(i>0&&a[i]!=a[i-1]){
	               max_len=Math.max(max_len,last>=0?i-last:i-current);
	               last=a[i]-a[i-1]==1?current:-1;
	               current=i;
	           }
	       }
	       max_len=Math.max(max_len,last>=0?i-last:i-current);
	       return max_len;
		
	}
	
	public static int[] count_dist(int[] a){
		
		int[] dist = new int[a.length];
		int[] count = new int[a.length-1];
		for(int i=0;i<a.length;i++){
			dist[i] = -1;
		}
		for(int i=0;i<a.length;i++){
			if(dist[i] < 0){
				dist = get_dist(a,dist,i);
			}
		}
		for(int i=0;i<dist.length;i++){
			if(dist[i]>0){
				count[dist[i]-1] += 1;
			}
		}
		
		return count;
	}
	
	
	public static int[] get_dist(int[] a, int[] dist, int i){
		
		int next = a[i];
		if(next == i){
			dist[i] =0;
			return dist;
		}else if(dist[next] > 0){
			dist[i] = dist[next] +1;
			return dist;
		}else{
			dist[i] = get_dist(a,dist,next)[next]+1;
			return dist;
		}
		
	}

}
