import java.util.*;
class frame
{
	int pagenumber = -1;
	int lastaccesstime = -1;
	void replaceframe(int pagenumber,int lastaccesstime)
	{
		this.pagenumber = pagenumber;
		this.lastaccesstime = lastaccesstime;
	}
	void refreshframe(int lastaccesstime)
	{
		this.lastaccesstime = lastaccesstime;
	}
}
public class pgm_9a
{
	public static frame cache[];
	public static int nF;
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of page requests");
		int nR = sc.nextInt();
		int pnumber[] = new int[nR];
		System.out.println("Enter page Requests");
		for(int i=0;i<nR;i++)
		{
			pnumber[i] = sc.nextInt();
		}
		System.out.println("Enter the number of frames");
		nF = sc.nextInt();
		cache = new frame[nF];
		for(int i=0;i<nF;i++)
		{
			cache[i] = new frame();
		}
		int hit = 0,fault = 0;
		for(int i=0;i<nR;i++)
		{
			int index = findpagenumber(pnumber[i]);
			if(index!=-1)
			{
				hit = hit+1;
				cache[index].refreshframe(i);
			}
			else
			{
				fault = fault+1;
				int temp = getlruindex();
				cache[temp].replaceframe(pnumber[i],i);
			}
		}
		System.out.println("Hit: "+hit);
		System.out.println("Fault: "+fault);
	}
	public static int findpagenumber(int pn)
	{
		for(int i=0;i<nF;i++)
		{
			if(pn == cache[i].pagenumber)
			{
				return i;
			}
		}
		return -1;
	}
	public static int getlruindex()
	{
		int min = cache[0].lastaccesstime;
		int index=0;
		for(int i=0;i<nF;i++)
		{
			if(cache[i].lastaccesstime<min){
				min=cache[i].lastaccesstime;
				index=i;
			}
		}
		return index;
	}
}
