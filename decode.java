import java.io.*;

class decode{
    public static void main(String[] args){
	try{
	    System.out.print("Code: ");
	    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	    String str = input.readLine();
	    System.out.println(fn(str));
	}
	catch(java.io.IOException exp){
	    exp.printStackTrace();
	}
    }
    public static int fn(String str){
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