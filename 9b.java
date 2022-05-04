import java.util.*;
import java.io.*;
 
public class fifo_9b{
	public static void main(String [] args)throws IOException{	
		int frame[] = new int[3];
 
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		n = Integer.parseInt(br.readLine());
		int ip[] = new int[n];
 
		System.out.println("Enter the inputs");
 
		for(int i=0;i<n;i++)
			ip[i] = Integer.parseInt(br.readLine());
 
		for(int i=0;i<3;i++)
			frame[i] = -1;
 
		int hit = 0;
		int fault = 0;
		int j = 0;
 
		boolean check;
		for(int i=0;i<n;i++){
			check = false;
			for(int k=0;k<3;k++){
				if(ip[i] == frame[k]){
					hit++;
					check = true;
				}
			}
			if(check == false){
				frame[j] = ip[i];
				fault++;
				j++;
			}
			j %= 3;	
		}
 
		System.out.println("Number of hits " + hit);
		System.out.println("Number of fault " + fault);
	}
}
