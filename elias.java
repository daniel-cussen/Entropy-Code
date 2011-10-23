import java.io.*;

public class elias{
    public static void main(String[] args){
	try{
	    System.out.print("Integer: ");
	    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(input.readLine());
	    System.out.println(encodeInt(n));
	}
	catch(java.io.IOException exp){
	    exp.printStackTrace();
	}
    }
    public static int loglen(int n){
	int i = 0;
	while (n > 0){
	    n >>= 1;
	    i ++;
	}
	return i;
    }
    public static int[] payload(int n){
	int count = 1, payload = n, y = 4, b = 3, prev = 0;
	int vec[] = new int[3];
	while(payload >= b){ //perhaps this loop should be unrolled
	    prev = b;
	    y *= y;
	    b += y;
	    b--;
	    count++;
	}
	payload -= prev;
	vec[0]=count;
	vec[1]=loglen(payload);
	if(vec[1]!=0)
	    vec[2]=(payload+1)%((1<<vec[1])/2);
	else
	    vec[2]=0;
	vec[1]--;
	return vec;
    }
    public static String binary(int n){
	String str = "";
	int aux = n;
	while(aux > 0){
	    str = ""+(aux & 1)+str;
	    aux >>= 1;
	}
	return str;
    }
    public static String padding(int x, String str, char c){
	int len = str.length();
	for(int i=len;i<x;i++){
	    str = c+str;
	}
	return str;
    }
    public static String encodeInt(int n){
	int payload[] = payload(n);
	return ""+padding(payload[0],"0",'1')+padding(payload[0],binary(payload[1]),'0')+
	  padding(payload[1],binary(payload[2]),'0');
    }
}