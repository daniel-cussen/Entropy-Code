import java.io.*;

public class elias{
    public static void main(String[] args){
	try{
	    System.out.print("Integer: ");
	    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(input.readLine());
	    System.out.println(""+loglen(n));
	}
	catch(java.io.IOException exp){
	    exp.printStackTrace();
	}
    }
	//
    public static int loglen(int n){
	int i = 0;
	while (n > 0){
	    n >>= 1;
	    i ++;
	}
	return i;
    }
    public static String binary(int n){
	String str = "";
	int aux = n;
	while(aux > 0){
	    aux >>= 1;
	    str = ""+(aux & 1)+str;
	}
	return str;
    }
    public static int[] payload(int n){
	int count = 1, payload = n, y = 4, b = 3, prev = 0;//shitty var names
	int vec[] = new int[3];
	while(payload >= b){
	    prev = b;
	    y *= y;
	    b += y;
	    b--;
	    count++;
	}
	payload -= prev;
	vec[0]=payload;
	vec[1]=count;
	vec[2]=loglen(payload);
	return vec;
    }
    public static String doubleformat(int x, int y){
	String str1="0", str2="";
	for(int i=0;i<x;i++){
	    
	}
	return str1+str2;    
    }

    public static String encodeInt(int n){
	int payload[] = payload(n);
	String str = ""+doubleformat(payload[0],payload[1])+binary(payload[3]);
	return str;
    }
    public static int decodeInt(String str){
	int n = 0, i = 0, bin = 0;
	while(str.charAt(i)=='1'){
	    n += (1 << (1 << ++i));
	    n--;
	}
	i++;
	int j = i, size = 0;
	i <<= 1;
	while(j < i){
	    size <<= 1;
	    size += (str.charAt(j) - 48);
	    j++;
	}
	n += ((1 << size) - 1);
	i += size;
	while(j < i){
	    bin <<= 1;
	    bin += (str.charAt(j) - 48);
	    j++;
	}
	n += bin;
	return n;
    }
}
