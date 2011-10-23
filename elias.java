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
	while(payload >= b){ //perhaps this loop should be unrolled since it will only operate on ints
	    prev = b;
	    y *= y;
	    b += y;
	    b--;
	    count++;
	}
	payload -= prev;
	vec[0]=count;
	vec[1]=loglen(payload);
	vec[2]=payload;
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
	//	return ""+payload[0]+" "+binary(payload[1])+" "+payload[2];
	return ""+payload[2];
	//	return ""+padding(payload[0],"0",'1')+" "+padding(payload[0],binary(payload[1]),'0')+
	//  " "+padding(payload[1],binary(payload[2]),'0');
    }
}


 0  0
 0  1 0
 0  1 1
10 00
10 01 0
10 01 1
10 10 00
10 10 01
10 10 10
10 10 11
10 11 000
10 11 001
10 11 010
10 11 011
10 11 100
10 11 101
10 11 110
10 11 111

3
15
255
65535

1
2

1
2
4
8

1
2
4
8
16
32
64
128